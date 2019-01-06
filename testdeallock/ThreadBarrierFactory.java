package testdeallock;

import java.util.concurrent.CyclicBarrier;

public class ThreadBarrierFactory {

	public static CyclicBarrier getInstance(int parties,Runnable barrierAction) {
		if(parties>0) {
			return new CyclicBarrier(parties, barrierAction);
		}else {
			return null;
		}
	}

}
