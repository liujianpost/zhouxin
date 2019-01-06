package map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

public class TaskExecutor implements Callable<String> {
	
	Set<String> set = new HashSet<>();
	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	
	int num;
	

	public TaskExecutor(Map<Integer, Integer> map,int num) {
		this.map = map;
		this.num = num;
	}


	@Override
	public String call() throws Exception {
		TestHashMap.barrier.await();
//		if(num==0) {
//			Thread.sleep(300);
//			map.put(101, 101);
//			System.out.println("线程"+num +"添加了新值");
//		}else {
//			for(Iterator<Entry<Integer,Integer>> it =map.entrySet().iterator();it.hasNext();) {
//				System.out.println("线程"+num +"开始遍历map");
//				Thread.sleep(500);
//				Entry<Integer,Integer> entry = it.next();
//				if(entry.getKey()==101) {
//					System.out.println("迭代器实时更新了");
//				}
//			}
//		}
		int i = map.put(10, num);
		TestHashMap.set.add(String.valueOf(i));
		System.out.println("线程"+num+"执行结果："+i);
		return "ok";
	}





}
