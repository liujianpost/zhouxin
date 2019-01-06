package map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import test.BarrierAction;

public class TestHashMap {
	 Map<Integer,Integer> map = new HashMap<>();
	static	Set<String> set = new HashSet<>();

	 static CyclicBarrier barrier = new CyclicBarrier(500,new BarrierAction());
	public static void main(String[] args) {
		TestHashMap instance = new TestHashMap();
		instance.fly();
	}
	private void fly() {
		ExecutorService service = Executors.newCachedThreadPool();
		for(int i=0;i<10;i++) {
			map.put(i, i);
		}
		for(int i=0;i<500;i++) {
			Future<String> future = service.submit(new TaskExecutor(map,i));
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(set.size());		
	}
	

}
