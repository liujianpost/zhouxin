package testreentrantlock;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import settest.MyTask;

public class TaskExecutor implements Runnable {
	
	private static final ReentrantLock LOCK = new ReentrantLock();
	private final NavigableSet<MyTask> taskSet = new TreeSet<MyTask>();
	private final Map<String,String> map = new HashMap<String,String>();
	private final Object lock1 = new Object();
	
	public void addTask(MyTask task) throws InterruptedException {
		if(!LOCK.tryLock(2, TimeUnit.SECONDS)) {
			System.out.println(task.getName() + "没有获取到锁，直接返回");
			return;
		}
		try {
			System.out.println(task.getName());
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOCK.unlock();
//		synchronized (lock1) {
//			LOCK.lock();
//			map.put("a", task.getName());
//			System.out.println("写入的值为：" + map.get("a"));
//			lock1.notifyAll();
//			System.out.println("准备唤醒");
//			LOCK.unlock();
//			System.out.println("readLock unlock");
//		}
	}

	@Override
	public void run() {
		while(true) {
			if(!map.isEmpty()) {
				System.out.println("读到的值为" +map.get("a"));
				map.clear();
			}
			synchronized(lock1) {
				while(map.isEmpty()) {
					try {
						System.out.println("等待被唤醒");
						lock1.wait();
						System.out.println("被唤醒了！");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
