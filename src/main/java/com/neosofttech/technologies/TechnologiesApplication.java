package com.neosofttech.technologies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class TechnologiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnologiesApplication.class, args);                
	}

}
