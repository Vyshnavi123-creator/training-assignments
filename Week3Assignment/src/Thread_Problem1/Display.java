package Thread_Problem1;

public class Display {

	public static synchronized void printMessage(String name) throws InterruptedException {
		System.out.println(name);
		System.out.println("in block "+name);
		Thread.sleep(500);
		System.out.println("in block "+name+" end");
	}

}


