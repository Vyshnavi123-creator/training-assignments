package com.vyshnavi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vyshnavi.demo.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
