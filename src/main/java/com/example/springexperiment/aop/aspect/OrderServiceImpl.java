package com.example.springexperiment.aop.aspect;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

	@Override
	public int order(int itemNumber) {
		log.info("order : {}", itemNumber);

		init();
		return itemNumber;
	}

	@Override
	public void init() {
		log.info("init method called");
	}
}
