package Problem2;

public abstract class Person {
	private String name;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "[name=" + name + ", address=" + address +
				 ", role()=" + role() + ", responsibility()=" + responsibility() + "]";
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public abstract String role();
	public abstract String responsibility();
}
