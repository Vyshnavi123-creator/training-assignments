package Lambda_Problem1;

public class Employee {
	private String department;
	private int salary;
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Employee(String department, int salary) {
		super();
		this.department = department;
		this.salary = salary;
	}
    
}
