package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.InstructorDetail;
@Repository
public interface InstructorDetailRepository extends JpaRepository<InstructorDetail, Integer> {

}
