package com.example.springexperiment.aop.jdk_dinamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import lombok.extern.slf4j.Slf4j;

/*
* InvocationHandler 를 구현한 객체로 프록시 객체가 수행할 부가 기능을 구현한다.
* 메소드 수행 전, 후에 로그를 찍는 부가 기능을 한다.
* target: 핵심 기능을 수행하는 원본 객체
* */
@Slf4j
public class LogInvocationHandler implements InvocationHandler {

	private final Object target;

	public LogInvocationHandler(Object target) {
		this.target = target;
	}

	/**
	 * @param proxy: 프록시 객체
	 * @param method: 원본 객체의 호출된 메소드 정보
	 * @param args: 원본 객체의 호출된 메소드의 인자 정보
	 * @return : 원본 객체의 호출된 메소드의 반환값
	 * @throws Throwable
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		log.info("method start: {}", method.getName());

		Object result = method.invoke(target, args);

		log.info("method end: {}", method.getName());

		return result;
	}
}
