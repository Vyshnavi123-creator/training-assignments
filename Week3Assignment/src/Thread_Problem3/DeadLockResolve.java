package Thread_Problem3;

public class DeadLockResolve {
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
    		System.out.println(Thread.currentThread().getName()+" released "+s1);
    		System.out.println(Thread.currentThread().getName()+" released "+s2);
    	}
    };
    Thread t2=new Thread() {
    	public void run() {
    		synchronized(s1) {
				System.out.println(Thread.currentThread().getName()+" locked "+s2);
				synchronized(s2) {
					System.out.println(Thread.currentThread().getName()+" locked "+s1);
					System.out.println(s1+s2);
				}
				
			}
    		System.out.println(Thread.currentThread().getName()+" released "+s1);
    		System.out.println(Thread.currentThread().getName()+" released "+s2);
    	}
    };
    public static void main(String[] args) {
    	DeadLockResolve d=new DeadLockResolve();
		d.t1.start();
		d.t2.start();
	}
}
