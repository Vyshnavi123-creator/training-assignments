package com.vyshnavi.demo.service;

import java.util.List;

import com.vyshnavi.demo.model.Student;

public interface StudentService {

	Student createStudent(Student student);
	Student updateStudent(Student student);
	List<Student> getAllStudent();
	Student getStudentById(int id);
	void deleteStudent(int id);
	
}
