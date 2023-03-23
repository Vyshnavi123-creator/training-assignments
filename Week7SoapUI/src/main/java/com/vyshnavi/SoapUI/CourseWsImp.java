package com.vyshnavi.SoapUI;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vyshnavi.SoapUI.entity.Course;
import com.vyshnavi.SoapUI.repository.CourseRepository;

@Service
public class CourseWsImp implements CourseWs {
	
	@Autowired
	private CourseRepository courserepo;

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courserepo.findAll();
	}

	@Override
	public Course getCourse(int id) {
		// TODO Auto-generated method stub
		return courserepo.findById(id).get();
	}

	@Override
	public Course createCourse(Course course) {
		// TODO Auto-generated method stub
		return courserepo.save(course);
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		return courserepo.save(course);
	}

	@Override
	public void deleteCourse(int id) {
		// TODO Auto-generated method stub
		courserepo.deleteById(id);;
	}
	

}
