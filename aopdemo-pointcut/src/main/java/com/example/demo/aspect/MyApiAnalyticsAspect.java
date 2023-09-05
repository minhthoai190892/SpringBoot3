package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
	@Before("com.example.demo.aspect.LuvAopExpression.forServicePackageNoGetterSetter()")
	public void perFormApi() {
		System.err.println("\n=======>>>>>>perFormApi advice on method");
	}
}
