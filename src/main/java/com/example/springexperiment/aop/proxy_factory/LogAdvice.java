package com.example.springexperiment.aop.proxy_factory;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogAdvice implements MethodInterceptor {

	/*
	* 원본 객체의 인터페이스 유무에 상관없이 MethodInterceptor 를 구현하면
	* 프록시 객체를 만들 수 있다.
	* */
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		log.info("method start: {}", invocation.getMethod().getName());

		Object result = invocation.proceed();

		log.info("method end: {}", invocation.getMethod().getName());

		return result;
	}
}
