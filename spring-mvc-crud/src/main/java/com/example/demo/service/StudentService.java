package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	public List<Student> findAll(){
		return studentRepository.findAll();
	}
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	public Student getStudentById(Integer id) {
		return studentRepository.findById(id).get();
	}
	public void deleteStudent(Integer id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);;
	}
}
