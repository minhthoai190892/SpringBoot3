package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@SpringBootApplication
public class SpringCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentService studentService) {
		return runner ->{
//			createStudent(studentService);
//			createMultipleStudents(studentService);
//			findbyId(studentService);
//			updateStudent(studentService);
			deleteById(studentService);
			listAllStudent(studentService);
//			listAllBySearch(studentService);
		};
	}
	private void deleteById(StudentService studentService) {
		// TODO Auto-generated method stub
		int id =8;
		studentService.delete(id);
		
		
	}
	private void updateStudent(StudentService studentService) {
		System.err.println("Update Student");
		// TODO Auto-generated method stub
		int id = 8;
		Student student = studentService.findById(id);
		student.setFirstName("student 8");
		student.setLastName("student 8");
		student.setEmail("student8@gmail.com");
		Student saveStudent = studentService.saveStudent(student);
		System.out.println(saveStudent);
		
		
	}
	private void listAllBySearch(StudentService studentService) {
		System.err.println("List All Student By Search");
		// TODO Auto-generated method stub
		String firstName = "3";
		List<Student> list = studentService.findAllBySearch(firstName);
		for (Student student : list) {
			System.out.println(student);
			
		}
	}
	private void listAllStudent(StudentService studentService) {
		// TODO Auto-generated method stub
		System.err.println("List All Student");
		List<Student> list = studentService.listAll();
		for (Student student : list) {
			System.out.println(student);
		}
	}
	private void findbyId(StudentService studentService) {
		System.err.println("Find By Id");
		// TODO Auto-generated method stub
		int id = 4;
		Student  student = studentService.findById(id);
		
		System.out.println(student);
		
	}
	private void createMultipleStudents(StudentService studentService) {
		// TODO Auto-generated method stub
		Student student2 = new Student("student 2", "student 2", "student2@gmail.com");
		Student student3 = new Student("student 3", "student 3", "student3@gmail.com");
		Student student4 = new Student("student 4", "student 4", "student4@gmail.com");
		studentService.saveStudent(student2);
		studentService.saveStudent(student3);
		studentService.saveStudent(student4);
	}
	private void createStudent(StudentService studentService) {
		// TODO Auto-generated method stub
		Student student = new Student("student 1", "student 1", "student1@gmail.com");
		studentService.saveStudent(student);
		System.out.println(student);
	}
}
