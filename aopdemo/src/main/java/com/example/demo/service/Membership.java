package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Membership {

	 public boolean addSillyMember() {
		System.out.println(getClass()+": Doing my db work: adding a membership account");
		return false;
	}
}
