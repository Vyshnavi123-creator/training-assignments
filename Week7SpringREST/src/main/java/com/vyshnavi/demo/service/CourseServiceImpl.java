package com.vyshnavi.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vyshnavi.demo.exception.StudentNotFoundException;
import com.vyshnavi.demo.model.Course;
import com.vyshnavi.demo.repository.CourseRepository;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository repo;
	
	@Override
	public Course createCourse(Course course) {
		
		return repo.save(course);
	}

	@Override
	public Course updateCourse(Course course) {
		Optional<Course> details=this.repo.findById(course.getId());
		
		if(details.isPresent()) {
			Course update=details.get();
			update.setId(course.getId());
			update.setTitle(course.getTitle());
			update.setDescription(course.getDescription());
			
			repo.save(update);
			return update;
		}else {
			throw new StudentNotFoundException("Course not found with id :"+course.getId());
		}
	}

	@Override
	public List<Course> getAllCourse() {
		
		return this.repo.findAll();
	}

	@Override
	public Course getCourseById(int id) {
       Optional<Course> details=this.repo.findById(id);
		
		if(details.isPresent()) {
			return details.get();
		}
		else {
			throw new StudentNotFoundException("Course not found with id :"+id);
		}
	}

	@Override
	public void deleteCourse(int id) {
        Optional<Course> details=this.repo.findById(id);
		
		if(details.isPresent()) {
			this.repo.delete(details.get());
		}
		else {
			throw new StudentNotFoundException("Course not found with id :"+id);
		}
		
	}

}
