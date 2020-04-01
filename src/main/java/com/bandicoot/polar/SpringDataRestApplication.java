package com.bandicoot.polar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.bandicoot.polar.service.impl.ClienteServiceImpl;

import lombok.extern.slf4j.Slf4j;


@ComponentScan(basePackages = {"com.bandicoot.polar.repository"})
@SpringBootApplication
@Slf4j
public class SpringDataRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestApplication.class, args);
		log.info("aqui empieza");
	}

}
