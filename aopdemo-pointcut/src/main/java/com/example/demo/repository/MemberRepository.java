package com.example.demo.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository {
	public boolean addSillyMember() ;
	public void goToSleep();
}
