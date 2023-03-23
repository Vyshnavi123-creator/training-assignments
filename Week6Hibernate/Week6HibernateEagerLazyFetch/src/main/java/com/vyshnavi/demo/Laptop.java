package com.vyshnavi.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Laptop {

	@Id
	private int id;
	private String name;
	@ManyToOne
	private Student student;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Laptop(int id, String name, Student student) {
		super();
		this.id = id;
		this.name = name;
		this.student = student;
	}
	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
