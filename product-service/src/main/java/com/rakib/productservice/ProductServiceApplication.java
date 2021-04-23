package com.rakib.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) throws URISyntaxException {
		SpringApplication.run(ProductServiceApplication.class, args);
		System.out.println("Swagger URL: "+ new URI("http://localhost:9091/swagger-ui/"));
	}

}
