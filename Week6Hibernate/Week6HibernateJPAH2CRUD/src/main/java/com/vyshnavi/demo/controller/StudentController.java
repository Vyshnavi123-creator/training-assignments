package com.vyshnavi.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vyshnavi.demo.model.Student;
import com.vyshnavi.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudent(){
		return ResponseEntity.ok().body(service.getAllStudent());
	}
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getAllStudentById(@PathVariable int id){
		return ResponseEntity.ok().body(service.getStudentById(id));
	}
	@PostMapping("/students")
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		return ResponseEntity.ok().body(this.service.createStudent(student));
	}
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student){
		student.setId(id);
		return ResponseEntity.ok().body(this.service.updateStudent(student));
	}
	@DeleteMapping("students/{id}")
	public HttpStatus deleteStudent(@PathVariable int id){
		this.service.deleteStudent(id);
		return HttpStatus.OK;
	}
}
