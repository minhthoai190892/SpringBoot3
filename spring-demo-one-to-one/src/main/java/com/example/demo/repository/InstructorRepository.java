package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Instructor;
@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
	@Query("select i from Instructor i join fetch i.courses where i.id = ?1")
	public Instructor findiInstructorByIdJoinFetch(Integer id);
}
