package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class LuvAopExpression {

//	this is where we add all of our related advices for logging
//	let's start with an @Before advice
	@Pointcut("execution(* com.example.demo.service.*.*(..))")
	public void forServicePackage() {
	};
	@Pointcut("execution(* com.example.demo.service.*.get*(..))")
	public void getter() {
	};
	@Pointcut("execution(* com.example.demo.service.*.set*(..))")
	public void setter() {
	};
	@Pointcut("forServicePackage() && !(getter() || setter())")
	public void forServicePackageNoGetterSetter() {
		
	}
}
