package test;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TaskManager {
	static Integer num = 0;
	
	static CyclicBarrier barrier = new CyclicBarrier(100,new BarrierAction());
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		for(int i=1;i<=5;i++) {
			Task task = new Task("Task" +i,i);
			Future<String> future =  service.submit(task);
				if(i==3) {
					boolean res = future.cancel(true);
					System.out.println("取消任务结果为：" +res);
				}
		}
		System.out.println("out of loop.");
	}

}
