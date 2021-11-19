package com.springexmple.springdemo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringdemoApplication {

	
	private static final Logger LOGGER=LoggerFactory.getLogger(SpringdemoApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringdemoApplication.class, args);
		
		LOGGER.info("Simple log statement with inputs {}, {} and {}", 1,2,3);
	}

}
