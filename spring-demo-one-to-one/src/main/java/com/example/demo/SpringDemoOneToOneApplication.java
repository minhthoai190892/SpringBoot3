package com.example.demo;

import java.util.Iterator;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import com.example.demo.entity.Review;
import com.example.demo.entity.Student;
import com.example.demo.service.InstructorService;

@SpringBootApplication
public class SpringDemoOneToOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoOneToOneApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorService instructorService) {
		return runner -> {
//			createInstructor(instructorService);
//			findInstructorById(instructorService);
//			deleteInstructorById(instructorService);
//			findInstructorDetailById(instructorService);
//			deleteInstructorDetailById(instructorService);
//			createInstructorWithCourse(instructorService);
//			updateCourseById(instructorService);
//			updateInstructorById(instructorService);
//			findiInstructorByIdJoinFetch(instructorService);
//			deleteInstructor(instructorService);
//			deleteCourse(instructorService);
//			createCourseAndReview(instructorService);
//			findCourseAndReviewsByCourseId(instructorService);
//			updateCourseAndReviewsByCourseId(instructorService);
//			deleteCourseAndReviewsByCourseId(instructorService);
//			createCourseAndStudent(instructorService);
//			findCourseAndStudentByCourseId(instructorService);
//			addStudentAndCourse(instructorService);
//			findStudentAndCourseByStudentId(instructorService);
//			deleteCourseAndStudent(instructorService);
			deleteStudentAndCourse(instructorService);
		};
	}

	private void deleteStudentAndCourse(InstructorService instructorService) {
		// TODO Auto-generated method stub
		System.err.println("deleteStudentAndCourse");
		Integer id = 2;
		instructorService.deleteStudent(id);

	}

	private void deleteCourseAndStudent(InstructorService instructorService) {
		// TODO Auto-generated method stubf
		System.err.println("deleteCourseAndStudent");
		Integer id = 4;
		instructorService.deleteCourse(id);

	}

	private void findStudentAndCourseByStudentId(InstructorService instructorService) {
		// TODO Auto-generated method stub
		System.err.println("findStudentAndCourseByStudentId");
		Integer Id = 2;
		Student student = instructorService.findStudentAndCourseByStudentId(Id);
		System.out.println(student);
		System.out.println(student.getListCourses());
	}

	private void addStudentAndCourse(InstructorService instructorService) {
		// TODO Auto-generated method stub
		System.err.println("addStudentAndCourse");
		Course course1 = instructorService.findCourseById(1);
		Course course4 = instructorService.findCourseById(4);
		Course course5 = instructorService.findCourseById(5);
		Course course6 = instructorService.findCourseById(6);
		Student student2 = instructorService.findStudentById(2);
		student2.addCourse(course1);
		student2.addCourse(course4);
		student2.addCourse(course5);
		student2.addCourse(course6);
		Student saveStudent = instructorService.saveStudent(student2);
		System.out.println(saveStudent);
		System.out.println(saveStudent.getListCourses());

	}

	private void findCourseAndStudentByCourseId(InstructorService instructorService) {
		// TODO Auto-generated method stub
		System.err.println("findCourseAndStudentByCourseId");
		Integer id = 4;
		Course course = instructorService.findCourseAndStudentByCourseId(id);
		System.out.println(course);
		System.out.println(course.getListStudents());

	}

	private void createCourseAndStudent(InstructorService instructorService) {
		System.err.println("createCourseAndStudent");
		// TODO Auto-generated method stub
		Integer courseId = 4;
		Course course = instructorService.findCourseById(courseId);
		System.out.println(course);
		Integer studentId = 1;
		Student student = instructorService.findStudentById(studentId);
		course.addStudent(student);
		Student student2 = new Student("student 5", "student 5", "student5@gmail.com");
		instructorService.saveStudent(student2);
		course.addStudent(student2);
		Course saveCourse = instructorService.saveCourse(course);
		System.out.println(saveCourse);
	}

	private void deleteCourseAndReviewsByCourseId(InstructorService instructorService) {
		System.err.println("deleteCourseAndReviewsByCourseId");
		// TODO Auto-generated method stub
		Integer id = 2;

		instructorService.deleteCourse(id);

	}

	private void updateCourseAndReviewsByCourseId(InstructorService instructorService) {
		// TODO Auto-generated method stub
		System.err.println("updateCourseAndReviewsByCourseId");
		Integer id = 2;
		Course course = instructorService.findCourseById(id);
		course.addReview(new Review("very Good"));
		Course saveCourse = instructorService.saveCourse(course);
		System.out.println(saveCourse);
		System.out.println(saveCourse.getListReviews());
	}

	private void findCourseAndReviewsByCourseId(InstructorService instructorService) {
		// TODO Auto-generated method stub
		System.err.println("findCourseAndReviewsByCourseId");
		Integer id = 6;
		Course course = instructorService.findCourseAndReviewsByCourseId(id);
		System.out.println(course);
		System.out.println(course.getListReviews());
	}

	private void createCourseAndReview(InstructorService instructorService) {
		System.err.println("createCourseAndReview");
		// TODO Auto-generated method stub
		Course course = new Course("new Course");
		Review review = new Review("Goode");
		Review review1 = new Review("Bad");
		course.addReview(review);
		course.addReview(review1);
		instructorService.saveCourse(course);
	}

	private void deleteCourse(InstructorService instructorService) {
		// TODO Auto-generated method stub
		Integer id = 3;
		instructorService.deleteCourse(id);

	}

	private void deleteInstructor(InstructorService instructorService) {
		// TODO Auto-generated method stub
		Integer id = 7;

		instructorService.deleteInstructor(id);

	}

	private void updateInstructorById(InstructorService instructorService) {
		// TODO Auto-generated method stub
		Integer id = 7;
		Instructor instructor = instructorService.findInstructorById(id);
		instructor.setLastName("Instructor 7");
		instructorService.saveInstructor(instructor);
	}

	private void updateCourseById(InstructorService instructorService) {
		// TODO Auto-generated method stub
		Integer id = 2;
		Course course = instructorService.findCourseById(id);
		course.setTitle("Course 2");
		instructorService.saveCourse(course);
	}

	private void findiInstructorByIdJoinFetch(InstructorService instructorService) {
		// TODO Auto-generated method stub
		System.err.println("findiInstructorByIdJoinFetch");
		Integer id = 6;
		Instructor instructor = instructorService.findInstructorByIdJoinFetch(id);
		System.out.println(instructor);
		System.out.println(instructor.getCourses());

	}

	private void createInstructorWithCourse(InstructorService instructorService) {
		// TODO Auto-generated method stub
		System.err.println("createInstructorWithCourse");

//		Instructor instructor = instructorService.findInstructorById(7);
//		Course course4 = instructorService.getCourseById(4);
//
//		instructorService.saveInstructor(instructor);
//		System.out.println(instructor);
//		System.out.println(instructor.getCourses());
		Integer id = 6;
		Instructor instructor = instructorService.findInstructorById(id);
		Course course1 = instructorService.findCourseById(1);
		Course course2 = instructorService.findCourseById(2);
		Course course3 = instructorService.findCourseById(3);
		instructor.addCourse(course1);
		instructor.addCourse(course2);
		instructor.addCourse(course3);
		System.out.println(instructor);
		instructorService.saveInstructor(instructor);
		List<Course> courses = instructorService.listCourses(id);
		instructor.setCourses(courses);
		System.out.println("Course: " + instructor.getCourses());

	}

	private void deleteInstructorDetailById(InstructorService instructorService) {
		System.err.println("deleteInstructorDetailById");
		Integer id = 4;
		// TODO Auto-generated method stub
		instructorService.deleteInstructorDetailById(id);
		System.out.println("done");

	}

	private void findInstructorDetailById(InstructorService instructorService) {
		System.err.println("findInstructorDetailById");
		// TODO Auto-generated method stub
		Integer id = 4;
		InstructorDetail detail = instructorService.findInstructorDetailById(id);
		System.out.println(detail);
		System.out.println(detail.getInstructor());
	}

	private void deleteInstructorById(InstructorService instructorService) {
		// TODO Auto-generated method stub
		System.err.println("deleteInstructorById");
		Integer id = 3;
		instructorService.deleteInstructorById(id);
		System.out.println("done");
	}

	private void findInstructorById(InstructorService instructorService) {
		// TODO Auto-generated method stub
		System.err.println("findInstructorById");
		int id = 1;
		Instructor instructor = instructorService.findInstructorById(id);
		System.out.println(instructor);
		System.out.println(instructor.getInstructorDetail());

	}

	private void createInstructor(InstructorService instructorService) {
		System.err.println("createInstructor");
		// TODO Auto-generated method stub
		Instructor instructor = new Instructor("instructor 5", "instructor 5", "instructor5@gmail.com");
		InstructorDetail detail = new InstructorDetail("google", "tennis");
		instructor.setInstructorDetail(detail);
		Instructor saveInstructor = instructorService.saveInstructor(instructor);
		System.out.println(saveInstructor);
	}
}
