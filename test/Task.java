package test;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {
	
	private int num;
	private String name ;
	
	public Task(String name,int i){
		this.name = name;
		this.num = i;
	}

//	@Override
//	public void run() {
////		System.out.println(name + "已到达关卡.");
//		try {
//			TaskManager.barrier.await();
//			System.out.println(name + "开始干活.");
//			if(name.contains("50")) {
//				throw new RuntimeException();
//			}
//		} catch (InterruptedException | BrokenBarrierException e) {
//			System.out.println(name + "抛出了异常 " +e.toString());
//		}
//	}

	@Override
	public String call() throws Exception {
		System.out.println(name +"开始执行");
		if(name.contains("500")) {
			throw new RuntimeException("一个异常");
		}
		return name;
	}

}
