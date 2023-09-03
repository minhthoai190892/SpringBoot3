package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	@Query("select c from Course c where instructor.id=?1")
	public List<Course> findCoursesByInstructorId(Integer id);
	@Query("select c from Course c join fetch c.listReviews where c.id=?1")
	public Course findCourseAndReviewsByCourseId(Integer id);
	@Query("select c from Course c join fetch c.listStudents where c.id=?1")
	public Course findCourseAndStudentByCourseId(Integer id);
}
