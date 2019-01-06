package testdeallock;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import test.BarrierAction;

public class Entrance {
	
	static CyclicBarrier barrier;
	
	public static void main(String[] args) {
		Entrance entrance = new Entrance();
		entrance.fly();
	}

	private void fly() {
		barrier = ThreadBarrierFactory.getInstance(2, new BarrierAction());
		ExecutorService service = Executors.newCachedThreadPool();
		Account zhouxin = new Account("ZhouXin", "001", 200f);
		Account liujian = new Account("LiuJian", "002", 200f);
		Account ohter = new Account("ohter", "003", 0f);
		service.execute(new TransferTask(zhouxin, liujian, 100f));
		service.execute(new TransferTask(liujian, zhouxin, 50f));
		try {
			Thread.sleep(1000L);
			System.err.println("周欣的余额：" + zhouxin.getBalance());
			System.err.println("刘坚的余额：" + liujian.getBalance());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public CyclicBarrier getBarrier() {
		return barrier;
	}
	
}
