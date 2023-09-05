package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Account;

@Repository
public interface AccountRepository {
	public void addAccount(Account account,boolean vipFlag);
	public boolean doWork() ;

	public String getName();

	public void setName(String name);

	public String getServiceCode();
	public void setServiceCode(String serviceCode);
}
