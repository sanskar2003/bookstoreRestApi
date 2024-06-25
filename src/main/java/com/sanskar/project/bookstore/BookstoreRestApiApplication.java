package com.sanskar.project.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BookstoreRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreRestApiApplication.class, args);
	}
}
