package settest;

import java.util.Comparator;

public class MyComparator implements Comparator<MyTask> {


	@Override
	public int compare(MyTask task1, MyTask task2) {
		return task1.getName().hashCode() - task2.getName().hashCode();
	}

}
