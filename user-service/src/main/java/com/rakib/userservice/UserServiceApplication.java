package com.rakib.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) throws URISyntaxException {
		SpringApplication.run(UserServiceApplication.class, args);
		System.out.println("Swagger URL: "+ new URI("http://localhost:9092/swagger-ui/"));
	}

}
