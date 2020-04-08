package com.bandicoot.polar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.extern.slf4j.Slf4j;

@EnableJpaRepositories(basePackages = {"com.bandicoot.polar.dao"})
@SpringBootApplication(scanBasePackages = {   "com.bandicoot.polar.exception"})
@Slf4j
public class SpringDataRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestApplication.class, args);
		log.info("aqui empieza");
	}
	
	
	 


	 
	 
}
