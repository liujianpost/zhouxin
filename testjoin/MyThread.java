package testjoin;

public class MyThread  extends Thread{

	@Override
	public synchronized void run() {
//		try {
//			Thread.sleep(3000L);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		for(int i=0;i<10;i++) {
			System.out.println(i);
		}
		
	}

}
