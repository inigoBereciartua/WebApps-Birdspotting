package com.example.birdspotting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.birdspotting.service.SpottedBirdService;
import com.example.birdspotting.service.SpottedBirdServiceImpl;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public SpottedBirdService spottedBirdService() {
		return new SpottedBirdServiceImpl();
	}
}
