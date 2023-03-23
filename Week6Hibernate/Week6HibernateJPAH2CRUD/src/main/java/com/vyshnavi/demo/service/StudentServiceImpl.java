package com.vyshnavi.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vyshnavi.demo.exception.StudentNotFoundException;
import com.vyshnavi.demo.model.Student;
import com.vyshnavi.demo.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository repo;
	
	@Override
	public Student createStudent(Student student) {
		
		return repo.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		Optional<Student> details=this.repo.findById(student.getId());
		
		if(details.isPresent()) {
			Student update=details.get();
			update.setId(student.getId());
			update.setFirstName(student.getFirstName());
			update.setLastName(student.getLastName());
			update.setEmail(student.getEmail());
			
			repo.save(update);
			return update;
		}else {
			throw new StudentNotFoundException("Student not found with id :"+student.getId());
		}
	}

	@Override
	public List<Student> getAllStudent() {
		
		return this.repo.findAll();
	}

	@Override
	public Student getStudentById(int id) {
       Optional<Student> details=this.repo.findById(id);
		
		if(details.isPresent()) {
			return details.get();
		}
		else {
			throw new StudentNotFoundException("Student not found with id :"+id);
		}
	}

	@Override
	public void deleteStudent(int id) {
        Optional<Student> details=this.repo.findById(id);
		
		if(details.isPresent()) {
			this.repo.delete(details.get());
		}
		else {
			throw new StudentNotFoundException("Student not found with id :"+id);
		}
		
	}

}
