package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@GetMapping("/list")
	public String showHome(Model model) {
		System.err.println("showHome");
		List<Student> students = studentService.findAll();
		for (Student student : students) {
			System.out.println(student);
		}
		model.addAttribute("pageTitle", "Student Directory");
		model.addAttribute("students", students);
		return "students/list-students";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {

		model.addAttribute("student", new Student());
		model.addAttribute("pageTitle", "Add Student Form");
		return "students/student-form";
	}

	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student student,RedirectAttributes redirectAttributes) {
		System.err.println("saveStudent");
		Student saveStudent = studentService.saveStudent(student);
		System.out.println(saveStudent);
		redirectAttributes.addFlashAttribute("message","Save successfully");
		return "redirect:/students/list";

	}
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(Model model,@PathVariable(name = "id") Integer id) {
		Student student = studentService.getStudentById(id);
		model.addAttribute("student",student);
		model.addAttribute("pageTitle","Update Student");
		System.err.println(id);
		return "students/student-form";
		
	}
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable(name = "id") Integer id,RedirectAttributes redirectAttributes) {
		studentService.deleteStudent(id);
		return "redirect:/students/list"; 
	}

}
