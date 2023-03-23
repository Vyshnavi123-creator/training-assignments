package com.vyshnavi.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {

	public static void main(String[] args) {
		
		Configuration con=new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory=con.buildSessionFactory(registry);
		Session session =sessionFactory.openSession();
		
		session.beginTransaction();
		Student s1=session.get(Student.class, 101);
		System.out.println(s1.getFirstName());
		List<Laptop> laps=s1.getLaptop();
//		for(Laptop l:laps) {
//			System.out.println(l);
//		}
		session.getTransaction().commit();
		
	}
}
