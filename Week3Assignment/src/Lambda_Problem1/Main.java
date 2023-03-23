package Lambda_Problem1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        List<Employee> list=new ArrayList<>();
        Employee e1=new Employee("CSE",20000);
        list.add(e1);
        Employee e2=new Employee("CSE",30000);
        list.add(e2);
        Employee e3=new Employee("IT",20000);
        list.add(e3);
        Employee e4=new Employee("ECE",50000);
        list.add(e4);
        Employee e5=new Employee("EEE",35000);
        list.add(e5);
        Employee e6=new Employee("IT",10000);
        list.add(e6);

        Map<String,Integer> map1 = new HashMap<String,Integer>();
        Map<String, List<Employee>> groupemployees = list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));

		for(String i:groupemployees.keySet())
		{
			Employee emp=groupemployees.get(i).stream().max((Comparator.comparing(Employee::getSalary))).get();
			map1.put(i, emp.getSalary());
		}

		map1.forEach((k,v)->System.out.println(k+" "+v));
	}

}
