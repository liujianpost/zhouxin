package test;

public class BarrierAction implements Runnable {

	@Override
	public void run() {
		System.out.println("所有线程准备就绪，开始干活");
	}

}
