package com.example.springexperiment.aop.not_proxy;

import lombok.extern.slf4j.Slf4j;

// 로그 기능을 수행하는 OrderService 의 프록시 객체
@Slf4j
public class BasicOrderServiceProxy implements BasicOrderService {

	private final BasicOrderService basicOrderService;

	public BasicOrderServiceProxy(BasicOrderService basicOrderService) {
		this.basicOrderService = basicOrderService;
	}

	@Override
	public int order(int itemNumber) {
		log.info("start order method ");

		int result = basicOrderService.order(itemNumber);

		log.info("end order method");

		return result;
	}
}
