package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import com.example.demo.entity.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.InstructorDetailRepository;
import com.example.demo.repository.InstructorRepository;
import com.example.demo.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class InstructorService {
	@Autowired
	private InstructorRepository instructorRepository;
	@Autowired 
	private InstructorDetailRepository detailRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private StudentRepository studentRepository;
	
	public Instructor saveInstructor(Instructor instructor) {
		return instructorRepository.save(instructor);
	}
	public Instructor findInstructorById(Integer id) {
		return instructorRepository.findById(id).get();
		
	}
	public void deleteInstructorById(Integer id) {
		instructorRepository.deleteById(id);
	}
	public InstructorDetail findInstructorDetailById(Integer id) {
		return detailRepository.findById(id).get();
	}
	public void deleteInstructorDetailById(Integer id) {
		// TODO Auto-generated method stub
		detailRepository.deleteById(id);
	}
	public Course saveCourse(Course course) {
		return courseRepository.save(course);
		
	}
	public Course findCourseById(Integer id) {
		return courseRepository.findById(id).get();
		
	}
	public List<Course> listCourses(Integer id) {
		return courseRepository.findCoursesByInstructorId(id);
		
	}
	public Instructor findInstructorByIdJoinFetch(Integer id) {
		return instructorRepository.findiInstructorByIdJoinFetch(id);
	}
	public void deleteInstructor(Integer id) {
		Instructor instructor = instructorRepository.findById(id).get();
		List<Course>courses = instructor.getCourses();
		for (Course course : courses) {
			course.setInstructor(null);
		}
		instructorRepository.deleteById(id);
	}
	public void deleteCourse(Integer id) {
		courseRepository.deleteById(id);
	}
	public Course findCourseAndReviewsByCourseId(Integer id) {
		return courseRepository.findCourseAndReviewsByCourseId(id);
	}
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	public Student findStudentById(Integer studentId) {
		// TODO Auto-generated method stub
		return studentRepository.findById(studentId).get();
	}
	public Course findCourseAndStudentByCourseId(Integer id) {
		return courseRepository.findCourseAndStudentByCourseId(id);
	}
	public Student findStudentAndCourseByStudentId(Integer Id) {
		return studentRepository.findStudentAndCourseByStudentId(Id);
		
	}
	public void deleteStudent(Integer id) {
		studentRepository.deleteById(id);
	}
}
