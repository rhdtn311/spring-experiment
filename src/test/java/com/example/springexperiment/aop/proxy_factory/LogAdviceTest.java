package com.example.springexperiment.aop.proxy_factory;

import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

class LogAdviceTest {

	@Test
	public void proxyFactory_로_프록시_생성() {
		ProxyFactoryOrderService proxyFactoryOrderServiceImpl = new ProxyFactoryOrderServiceImpl();

		NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
		pointcut.setMappedNames("order*");

		LogAdvice logAdvice = new LogAdvice();
		DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, logAdvice);

		ProxyFactory proxyFactory = new ProxyFactory(proxyFactoryOrderServiceImpl);
		proxyFactory.addAdvisors(advisor);

		ProxyFactoryOrderService proxyFactoryOrderService = (ProxyFactoryOrderService)proxyFactory.getProxy();

		proxyFactoryOrderService.order(100);
	}
}