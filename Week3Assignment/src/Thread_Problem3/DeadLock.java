package Thread_Problem3;

public class DeadLock {
    String s1="Vyshnavi";
    String s2=" Rapolu";
    Thread t1=new Thread() {
    	public void run() {
    		synchronized(s1) {
				try {
					System.out.println(Thread.currentThread().getName()+" locked "+s1);
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized(s2) {
					System.out.println(Thread.currentThread().getName()+" locked "+s2);
					System.out.println(s1+s2);
				}
				
			}
    	}
    };
    Thread t2=new Thread() {
    	public void run() {
    		synchronized(s2) {
				System.out.println(Thread.currentThread().getName()+" locked "+s2);
				synchronized(s1) {
					System.out.println(Thread.currentThread().getName()+" locked "+s1);
					System.out.println(s1+s2);
				}
			}
    	}
    };
    public static void main(String[] args) {
    	DeadLock d=new DeadLock();
		d.t1.start();
		d.t2.start();
	}
}
