package com.example.springexperiment.aop.jdk_dinamic_proxy;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DynamicProxyOrderServiceImpl implements DynamicProxyOrderService {

	@Override
	public int order(int itemNumber) {

		log.info("start order: {}", itemNumber);

		return itemNumber;
	}
}
