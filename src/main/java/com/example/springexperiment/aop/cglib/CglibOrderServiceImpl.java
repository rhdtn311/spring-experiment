package com.example.springexperiment.aop.cglib;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CglibOrderServiceImpl implements CglibOrderService {

	@Override
	public int order(int itemNumber) {

		log.info("start order: {}", itemNumber);

		return itemNumber;
	}
}
