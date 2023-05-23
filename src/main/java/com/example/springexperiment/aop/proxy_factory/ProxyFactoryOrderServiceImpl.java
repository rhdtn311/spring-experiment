package com.example.springexperiment.aop.proxy_factory;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProxyFactoryOrderServiceImpl implements ProxyFactoryOrderService {

	@Override
	public int order(int itemNumber) {

		log.info("start order: {}", itemNumber);

		return itemNumber;
	}

	@Override
	public int sell(int itemNumber) {

		log.info("start sell: {}", itemNumber);

		return itemNumber;
	}
}
