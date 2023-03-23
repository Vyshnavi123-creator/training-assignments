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

import com.vyshnavi.demo.model.Course;
import com.vyshnavi.demo.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService service;
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllStudent(){
		return ResponseEntity.ok().body(service.getAllCourse());
	}
	@GetMapping("/courses/{id}")
	public ResponseEntity<Course> getAllStudentById(@PathVariable int id){
		return ResponseEntity.ok().body(service.getCourseById(id));
	}
	@PostMapping("/courses")
	public ResponseEntity<Course> createStudent(@RequestBody Course course){
		return ResponseEntity.ok().body(this.service.createCourse(course));
	}
	@PutMapping("/courses/{id}")
	public ResponseEntity<Course> updateStudent(@PathVariable int id, @RequestBody Course course){
		course.setId(id);
		return ResponseEntity.ok().body(this.service.updateCourse(course));
	}
	@DeleteMapping("courses/{id}")
	public HttpStatus deleteStudent(@PathVariable int id){
		this.service.deleteCourse(id);
		return HttpStatus.OK;
	}
}
