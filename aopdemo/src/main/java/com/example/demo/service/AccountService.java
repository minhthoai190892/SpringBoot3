package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;


@Service
public class AccountService {

	public void addAccount(Account account,boolean vipFlag) {
		System.out.println(getClass()+": Doing my db work: adding an account");
	}
}
