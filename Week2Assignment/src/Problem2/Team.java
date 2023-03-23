package Problem2;

import javax.print.Doc;

public class Team {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//STUDENT
        Person s=new Student();
        s.setName("Vyshnavi");
        s.setAddress("Hyderabad");
        System.out.println(s.toString());
        
        //TEACHER
        Teacher t=new Teacher();
        t.setName("Problems");
        t.setAddress("Hyderabad");
        System.out.println(t.toString());
        
        //PROBLEM
        Doctor d=new Doctor();
        d.setName("Time");
        d.setAddress("Hyderabad");
        System.out.println(d.toString());
	}

}
