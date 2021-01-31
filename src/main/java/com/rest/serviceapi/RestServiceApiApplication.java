package com.rest.serviceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

public class RestServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApiApplication.class, args);
	}

}
