package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.MemberRepository;

@Service
public class MemberService implements MemberRepository {

	@Override
	public boolean addSillyMember() {
		System.out.println(getClass()+": DOING MY DB WORK: ADDING A MEMBER");

		return true;
	}

	@Override
	public void goToSleep() {
		// TODO Auto-generated method stub
		System.out.println(getClass()+": I'm going to sleep now ..");
	}

}
