package com.example.demo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {
	// setup logging
	private Logger logger = Logger.getLogger(getClass().getName());

	// setup pointcut declaration
	@Pointcut("execution(* com.example.demo.controller.*.*(..))")
	private void forControllerPackage() {
	};

	// do the same for service and repository
	@Pointcut("execution(* com.example.demo.service.*.*(..))")
	private void forServicePackage() {
	};

	@Pointcut("execution(* com.example.demo.prpository.*.*(..))")
	private void forRepositoryPackage() {
	};

//	combine pointcut
	@Pointcut("forControllerPackage()||forServicePackage()||forRepositoryPackage()")
	private void forAppFlow() {
	};

	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
//		display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		logger.info("=======> in @Before: calling method: " + theMethod);
//		display the arguments to the method
		// --get the arguments
		Object[] args = theJoinPoint.getArgs();
		// --loop thru and display args
		for (Object tempArg : args) {
			logger.info("======> argument: " + tempArg);
		}
	}

	@AfterReturning(pointcut = "forAppFlow()",returning = "theResult")
	public void afterReturnring(JoinPoint theJoinPoint,Object theResult) {
//		display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		logger.info("=======> in @AfterReturning: from method: " + theMethod);
//		display data returned
		logger.info("=======> resulte: " + theResult);
	}
}
