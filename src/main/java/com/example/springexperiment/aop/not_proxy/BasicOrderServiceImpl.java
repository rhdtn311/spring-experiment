package com.example.springexperiment.aop.not_proxy;

import lombok.extern.slf4j.Slf4j;

// 핵심 기능을 수행하는 OrderService 의 구현체
@Slf4j
public class BasicOrderServiceImpl implements BasicOrderService {

	@Override
	public int order(int itemNumber) {
		log.info("{}", itemNumber);

		return itemNumber;
	}
}
