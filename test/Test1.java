package test;

public class Test1 {
	public static void main(String[] args) {
		int u=32;
		int v=26;
		while(v!=0) {
			int temp=u%v;
			u=v;
			v=temp;
		}
		System.out.println(u);
	}
}
