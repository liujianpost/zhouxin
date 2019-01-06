package test;

public class TestGeneric {
	    public static void main(String[] args) {
	    	
//	    	Box<String> box1 = new Box<String>("corn");
//	    	box1.setData("apple");
//	    	System.out.println("name:" + box1.getData());
	    	Box<Integer> box2 = new Box<Integer>(2);
//	    	System.out.println("name:" + box2.getData());
//	    	Class box1ClassObj = box1.getClass();
	    	Class box2ClassObj = box2.getClass();
	    	//System.out.println(box1ClassObj == box2ClassObj);//同一个class对象
	    	Box<Float> box3 = new Box<Float>(3.14f);
	    	
//	    	getData(box1);
//	    	getData(box2);
//	    	getData(box3);
	    	haha(02001, "张三","李四","王五");
	    }
	    
	    public static void getData(Box<? extends Number> data) {
	    	System.out.println("data :" + data.getData());
	    }
	    
	    public static void haha(int classNum,String... name) {
	    	System.out.println("班级序号："+ classNum);
	    	for(String each:name) {
	    		System.out.println("学生姓名："+ each);
	    	}
	    }
}

class Box<E extends Number>{
	private E data;
	
	public Box() {
		
	}
	
	public Box(E data) {
		this.data = data;
	}
	
	public E getData() {
		return this.data;
	}
	
	public void setData(E data) {
		this.data = data;
	}
	
}