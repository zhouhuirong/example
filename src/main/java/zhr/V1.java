package zhr;

public class V1 extends Thread{

	public void run () {
		System.out.println("1");
	}
	
	public static void main(String[] args) {
		V1 v1 = new V1();
		v1.start();
	}
}
