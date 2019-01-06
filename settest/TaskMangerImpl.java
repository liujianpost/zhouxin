package settest;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import test.BarrierAction;

public class TaskMangerImpl {
	
	static CyclicBarrier barrier = new CyclicBarrier(3,new BarrierAction());
	
	private static final MyTaskExecutor taskExecutor = new MyTaskExecutor();
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
			service.submit(taskExecutor);
			for(int i=0;i<3;i++) {
				service.submit(new AddTaskThread("task" + (i + 1)));
			}
		
	}
	public static MyTaskExecutor getTaskexecutor() {
		return taskExecutor;
	}
	
	

}
