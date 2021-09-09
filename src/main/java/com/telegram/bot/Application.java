package com.telegram.bot;

import com.telegram.bot.repository.RateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	@Autowired
	RateRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}



}

