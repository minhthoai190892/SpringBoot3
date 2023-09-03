package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	@Query("select s from Student s join fetch s.listCourses where s.id=?1")
	public Student findStudentAndCourseByStudentId(Integer id);
}
