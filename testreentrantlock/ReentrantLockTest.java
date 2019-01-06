package testreentrantlock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest implements Runnable{
    public static final ReentrantLock  LOCK = new ReentrantLock();
    private static final CyclicBarrier barrier = new CyclicBarrier(2);
    
    public static int i = 0;

    @Override
    public void run() {
    	try {
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
        for (int j = 0; j < 10; j++) {
        	LOCK.lock();  // 看这里就可以
            //lock.lock(); ①
            try {
                i++;
            } finally {
            	LOCK.unlock(); // 看这里就可以
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest test = new ReentrantLockTest();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.start();
        t2.start();
        Thread.sleep(200L);
        System.err.println(i);
    }
}
