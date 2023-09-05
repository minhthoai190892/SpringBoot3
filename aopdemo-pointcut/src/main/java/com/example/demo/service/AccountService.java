package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;

@Service
public class AccountService implements AccountRepository{
	private String name;
	private String serviceCode;
	@Override
	public void addAccount(Account account, boolean vipFlag) {
		// TODO Auto-generated method stub
		System.out.println(getClass()+": DOING MY DB WORK: ADDING AN ACCOUNT");
	}

	@Override
	public boolean doWork() {
		// TODO Auto-generated method stub
		System.out.println(getClass()+": doWork");
		return false;
	}

	public String getName() {
		System.out.println(getClass()+": in getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+": in setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+": in getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+": in setServiceCode");
		this.serviceCode = serviceCode;
	}

}
