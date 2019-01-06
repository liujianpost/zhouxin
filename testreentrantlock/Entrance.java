package testreentrantlock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import settest.MyTask;
import test.BarrierAction;

public class Entrance {

	private final TaskExecutor taskExecutor = new TaskExecutor();
	
	private static final CyclicBarrier barrier = new CyclicBarrier(6, new BarrierAction());
	
	public static void main(String[] args) {
		Entrance entrance = new Entrance();
		entrance.fly();
	}

	private void fly() {
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(taskExecutor);
		for(int i = 0 ;i  < 6;i++) {
			service.execute(new AddTaskThread(new MyTask("task" + i)));
		}
	}
	
	class AddTaskThread implements Runnable{
		
		MyTask task;
		
		public AddTaskThread(MyTask task) {
			this.task = task;
		}

		@Override
		public void run() {
			try {
				barrier.await();
				taskExecutor.addTask(task);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
