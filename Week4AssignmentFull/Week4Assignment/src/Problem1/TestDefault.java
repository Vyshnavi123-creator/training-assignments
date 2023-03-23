package Problem1;

public class TestDefault implements DefaultInInterface{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        TestDefault t=new TestDefault();
        t.show();
        t.greet("Vyshnavi");
	}

	@Override
	public void greet(String name) {
		// TODO Auto-generated method stub
		System.out.println("Hi "+name);
	}

}

