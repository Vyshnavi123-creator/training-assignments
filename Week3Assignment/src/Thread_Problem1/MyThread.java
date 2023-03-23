package Thread_Problem1;

class MyThread extends Thread{
	Display d;
	String name;
	MyThread(Display d,String name){
		this.d=d;
		this.name=name;
	}
	public synchronized void run() {
		try {
			
			Display.printMessage(name);
		} catch (InterruptedException e) {}
	}
}
