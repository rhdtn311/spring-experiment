package com.example.springexperiment.aop.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogMethodInterceptor implements MethodInterceptor {

	private final Object target;

	public LogMethodInterceptor(Object target) {
		this.target = target;
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		log.info("method start: {}", method.getName());

		Object result = proxy.invoke(target, args);

		log.info("method end: {}", method.getName());

		return result;
	}
}
