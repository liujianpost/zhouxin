package settest;

import java.util.TreeSet;

public class MyTaskExecutor implements Runnable {
	
	private final TreeSet<MyTask> taskSet = new TreeSet<MyTask>(new MyComparator());
	
	private final Object lock = new Object();

	
	public void addTask(MyTask task) {
		synchronized (lock) {
			System.out.println("获取到了lock锁，准备获取taskSet锁");
				taskSet.add(task);
				lock.notifyAll();
				System.out.println("任务已添加到任务列表，唤醒线程");
		}
	}



	@Override
	public void run(){
		while(true) {
				if(!taskSet.isEmpty()) {
					MyTask task = taskSet.pollFirst();	
					System.out.println(task.getName() + "开始执行任务.");
					try {
						Thread.sleep(1000L);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(task.getName() + "执行任务完毕!");
				}
			synchronized (lock) {
				while(taskSet.isEmpty()) {
					System.out.println("没有任务，阻塞线程.");
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("有新任务，线程被唤醒了！");
				}
			}
			
		}
	}

}
