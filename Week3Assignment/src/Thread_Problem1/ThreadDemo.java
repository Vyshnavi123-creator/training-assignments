package Thread_Problem1;

public class ThreadDemo{
	public static void main(String[] args) throws InterruptedException {
		Display d1=new Display();
		Display d2=new Display();
		Display d3=new Display();
		
		
		MyThread t1=new MyThread(d1,"thread1");
		t1.start();
		
		MyThread t2=new MyThread(d2,"thread2");
		t2.start();
		
		MyThread t3=new MyThread(d3,"thread3");
		t3.start();
		
		
	}
}
