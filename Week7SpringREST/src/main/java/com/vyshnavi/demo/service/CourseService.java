package com.vyshnavi.demo.service;

import java.util.List;

import com.vyshnavi.demo.model.Course;

public interface CourseService {

	Course createCourse(Course course);
	Course updateCourse(Course course);
	List<Course> getAllCourse();
	Course getCourseById(int id);
	void deleteCourse(int id);
	
}
