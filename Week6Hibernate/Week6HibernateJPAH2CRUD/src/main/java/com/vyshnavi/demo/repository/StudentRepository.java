package com.vyshnavi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vyshnavi.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
