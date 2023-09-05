package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
//	this is where we add all of our related advices for logging
	
//	let's start with an @Before advice
//	public void addAccount() hàm cần gọi
//	@Before("execution(public void com.example.demo.service.AccountService.addAccount())")
//	@Before("execution(public void add*())") //chỉ trả về kểu void

//	@Before("execution(public * add*(com.example.demo.entity.Account))")//trả kết quả về bất kỳ kểu nào
//	@Before("execution(public * add*(com.example.demo.entity.Account,..))")//trả về kết quả với nhiều tham số
	@Before("execution(public * add*(..))")
	public void beforeAddAccountAdvice() {
		System.err.println("\n==========> Executing @Before advice on addAccount");
	}
}
