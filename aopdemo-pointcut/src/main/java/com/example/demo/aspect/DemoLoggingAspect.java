package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Account;

@Aspect
@Component
@Order(2)
public class DemoLoggingAspect {
	@Before("com.example.demo.aspect.LuvAopExpression.forServicePackageNoGetterSetter()")
	public void beforeAddAccoutAdvice(JoinPoint theJoinPoint) {
		System.err.println("\n=======>>>>>>Executing @Before advice on method");

//		display the method signature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: "+methodSignature);
//		display method argument
		//get args
		Object[] args = theJoinPoint.getArgs();
		//loop thru args
		for (Object tempArg : args) {
			System.out.println(tempArg);
			if (tempArg instanceof Account) {
				//downcast and print Account specific stuff
				Account account  = (Account) tempArg;
				System.out.println("account name: "+account.getName());
				System.out.println("account level: "+account.getLevel());
			}
		}
	}

}
