package settest;

import java.util.concurrent.BrokenBarrierException;

public class AddTaskThread implements Runnable {
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public AddTaskThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		try {
			TaskMangerImpl.barrier.await();
			TaskMangerImpl.getTaskexecutor().addTask(new MyTask(name));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}

	}

}
