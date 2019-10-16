package com.loadwave.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BasicOperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicOperationsApplication.class, args);
	}

}
