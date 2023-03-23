package com.vyshnavi.SoapUI;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.vyshnavi.SoapUI.entity.Course;

@WebService
public interface CourseWs {
	@WebMethod
	public List<Course> getCourses();
	@WebMethod
	public Course getCourse(int id);
	
	@WebMethod
	public Course createCourse(Course course);
	@WebMethod
	public Course updateCourse(Course course);
	@WebMethod
	public void	 deleteCourse(int id);
}
