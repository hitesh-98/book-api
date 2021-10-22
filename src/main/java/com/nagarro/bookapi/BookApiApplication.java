package com.nagarro.bookapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@ComponentScan({"com.nagarro.bookapi.controller","com.nagarro.bookapi.dao","com.nagarro.bookapi.service"})
@EnableAutoConfiguration
@CrossOrigin(origins="http://localhost:8282")
public class BookApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApiApplication.class, args);
	}

}
