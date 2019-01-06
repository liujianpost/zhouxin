package testjoin;

public class Entrance {
	
	static Object lock = new Object();
	public static void main(String[] args) {
		MyThread t1 = new MyThread();
			t1.start();
			try {
				t1.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		System.out.println("end");
	}

}
