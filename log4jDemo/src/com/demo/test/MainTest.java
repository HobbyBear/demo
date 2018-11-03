package com.demo.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainTest {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(MainTest.class);
		logger.debug("这是debug信息");
		logger.error("这是一条错误信息");
	}
}
