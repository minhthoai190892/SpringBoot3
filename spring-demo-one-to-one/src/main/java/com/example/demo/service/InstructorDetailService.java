package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.InstructorDetail;
import com.example.demo.repository.InstructorDetailRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class InstructorDetailService {
	@Autowired
	private InstructorDetailRepository instructorDetailRepository;
	public InstructorDetail	getInstructorDetail(Integer id) {
		return instructorDetailRepository.findById(id).get();
	}
}
