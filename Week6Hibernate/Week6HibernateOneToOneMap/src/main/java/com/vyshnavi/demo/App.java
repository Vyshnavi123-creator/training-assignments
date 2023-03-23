package com.vyshnavi.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {

	public static void main(String[] args) {
		Laptop lap=new Laptop();
		lap.setId(1);
		lap.setName("hp");
		
		Student stud=new Student();
		stud.setFirstName("Vyshnavi");
		stud.setRollno(1);
		stud.setMarks(95);
		stud.setLaptop(lap);
		
		Configuration con=new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory=con.buildSessionFactory(registry);
		Session session =sessionFactory.openSession();
		
		session.beginTransaction();
		
		session.save(lap);
		session.save(stud);
		
		session.getTransaction().commit();
		
	}
}
