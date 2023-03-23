package Problem1;

public interface DefaultInInterface {
	default void show() {
		System.out.println("I am in Default method of an interface");
	}
    public void greet(String name);
}
