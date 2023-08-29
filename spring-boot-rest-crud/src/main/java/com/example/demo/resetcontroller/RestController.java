package com.example.demo.resetcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Student;

import com.example.demo.service.StudentSevice;

import jakarta.annotation.PostConstruct;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired
	private StudentSevice sevice;
	private List<Student> list;

	@PostConstruct
	public void loadData() {
		System.err.println("loadData");
		list = ((StudentSevice) sevice).listAll();
		for (Student student : list) {
			System.out.println(student);
		}
	}

	@GetMapping("/students")
	public List<Student> showList() {

		return sevice.listAll();
	}

	@GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable int id) {
		return sevice.getCountStudentById(id);
	}

	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		student.setId(0);
		return sevice.saveStudent(student);
	}

	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {
		return sevice.saveStudent(student);
	}

	@DeleteMapping("/students/{id}")
	public void deleteStudent(@PathVariable int id) {
		Student student = sevice.getCountStudentById(id);
		sevice.deleteStudent(student.getId());
	}
}
