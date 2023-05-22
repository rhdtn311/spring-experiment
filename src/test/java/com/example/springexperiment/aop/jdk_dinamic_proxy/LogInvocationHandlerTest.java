package com.example.springexperiment.aop.jdk_dinamic_proxy;

import java.lang.reflect.Proxy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.springexperiment.aop.not_proxy.BasicOrderService;
import com.example.springexperiment.aop.not_proxy.BasicOrderServiceImpl;
import com.example.springexperiment.aop.not_proxy.BasicOrderServiceProxy;

class LogInvocationHandlerTest {

	/*
	* Java 코드로 구현한 프록시
	* 핵심 기능은 impl 에서, 부가 기능은 proxy 에서 구현하여 관심사를 분리
	* 부가 기능을 구현해줘야 하는 객체가 늘어날 때마다 Proxy 클래스를 직접 구현해 줘야 한다.
	* */
	@Test
	void 기본_프록시_구현() {

		BasicOrderService basicOrderServiceImpl = new BasicOrderServiceImpl();
		BasicOrderService basicOrderServiceProxy = new BasicOrderServiceProxy(basicOrderServiceImpl);

		int itemNumber = 10;

		/*
		* << 출력 >>
		* 10
		* */
		basicOrderServiceImpl.order(itemNumber);

		/*
		* << 출력 >>
		* start order method
		* 10
		* end order method
		* */
		basicOrderServiceProxy.order(itemNumber);
	}

	/*
	* 리플랙션을 이용하여 구현한 JDK Dynamic 프록시
	* */
	@Test
	void 리플랙션을_사용한_JDK_Dynamic_프록시_객체() {
		DynamicProxyOrderService dynamicProxyOrderServiceImpl = new DynamicProxyOrderServiceImpl();

		LogInvocationHandler orderServiceLogInvocationHandler = new LogInvocationHandler(dynamicProxyOrderServiceImpl);

		DynamicProxyOrderService dynamicProxyOrderServiceProxy = (DynamicProxyOrderService)Proxy.newProxyInstance(
				DynamicProxyOrderService.class.getClassLoader(),
				new Class[] {DynamicProxyOrderService.class},
				orderServiceLogInvocationHandler
		);

		/*
		* << 출력 >>
		* start order: 1
		* */
		dynamicProxyOrderServiceImpl.order(1);

		/*
		 * << 출력 >>
		 * method start: order
		 * start order: 2
		 * method end: order
		 * */
		dynamicProxyOrderServiceProxy.order(2);
	}

	/*
	* JDK Dynamic Proxy 는 인터페이스를 통해
	* */
	@Test
	void 클래스로_JDK_Dynamic_프록시를_구현할_경우_예외_발생() {
		DynamicProxyOrderService dynamicProxyOrderServiceImpl = new DynamicProxyOrderServiceImpl();

		Assertions.assertThrows(IllegalArgumentException.class, () -> {

			LogInvocationHandler orderServiceLogInvocationHandler = new LogInvocationHandler(dynamicProxyOrderServiceImpl);
			DynamicProxyOrderServiceImpl dynamicProxyOrderServiceImplProxy = (DynamicProxyOrderServiceImpl)Proxy.newProxyInstance(
					DynamicProxyOrderServiceImpl.class.getClassLoader(),
					new Class[] {DynamicProxyOrderServiceImpl.class},
					orderServiceLogInvocationHandler
			);
		});
	}
}