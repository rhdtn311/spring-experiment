package com.example.springexperiment.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class MyAspect {

	@Around("execution (* com.example.springexperiment.aop..OrderService.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
    log.info("before - aop");

		return joinPoint.proceed();
  }
}
