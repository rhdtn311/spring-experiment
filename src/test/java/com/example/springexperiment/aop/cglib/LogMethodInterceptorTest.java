package com.example.springexperiment.aop.cglib;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

class LogMethodInterceptorTest {

	@Test
	public void cglib_proxy_생성() {
		CglibOrderService cglibOrderService = new CglibOrderServiceImpl();

		LogMethodInterceptor logMethodInterceptor = new LogMethodInterceptor(cglibOrderService);

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(CglibOrderService.class);
		enhancer.setCallback(logMethodInterceptor);
		CglibOrderService cglibOrderServiceProxy = (CglibOrderService)enhancer.create();

		cglibOrderServiceProxy.order(10);
	}
}