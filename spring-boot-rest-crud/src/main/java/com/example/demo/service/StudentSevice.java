package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.entity.Student;
import com.example.demo.exception.StudentErrorResponse;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentSevice {
	@Autowired
	private StudentRepository studentRepository;

	public List<Student> listAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	public Student getStudentById(int id) {
		return studentRepository.findById(id).get();
	}

	public Student getCountStudentById(Integer id) {
		Long countById = studentRepository.countById(id);
		if (countById == null || countById == 0) {
			throw new StudentNotFoundException("Student id not found:  " + id);
		}
		return studentRepository.findById(id).get();
	}

	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}
}
