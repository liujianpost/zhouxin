package settest;

public class MyTask implements Comparable<MyTask> {
	
	private String name;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public MyTask(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(MyTask task) {
		
		return this.name.hashCode()-task.getName().hashCode();
	}

	@Override
	public String toString() {
		return "MyTask [name=" + name + "]";
	}

}
