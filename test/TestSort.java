package test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestSort implements Runnable{
	
	long i ;
	public TestSort(long i) {
		System.out.println("enter TestSort constructor,i="+i);
		this.i = i;
	}
	public static void main(String[] args) {
		System.out.println("enter main method");
		long[] arr = {1,3,5,7,2};
		ScheduledExecutorService es = Executors.newScheduledThreadPool(5);
		for(int i=0;i<arr.length;i++) {
			long j = arr[i];
			System.out.println(j);
//			es.schedule(new TestSort(arr[i]), 3, TimeUnit.SECONDS);
			es.scheduleAtFixedRate(new TestSort(arr[i]), i, 3, TimeUnit.SECONDS);
		}
	}

	@Override
	public void run() {
			System.out.println(i);
	}

}
