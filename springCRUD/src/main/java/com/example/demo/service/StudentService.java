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
	private StudentRepository repository;
	public Student saveStudent(Student student) {
		return repository.save(student);
	}
	public Student findById(int id) {
		return repository.findById(id).get();
	}
	public List<Student> listAll() {
		return repository.findAll();
	}
	public List<Student> findAllBySearch(String keyword) {
		return repository.findAllSearch(keyword);
	}
	public void delete(int id) {
		repository.deleteById(id);
	}
}
