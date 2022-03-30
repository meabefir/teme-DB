package com.example.temaspring4ShopifyGetsExposed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class TemaSpring4ShopifyGetsExposedApplication {

	public static void main(String[] args) {
//		SpringApplication.run(TemaSpring4ShopifyGetsExposedApplication.class, args);
		SpringApplication app = new SpringApplication(TemaSpring4ShopifyGetsExposedApplication.class);
		app.setDefaultProperties(Collections
				.singletonMap("server.port", "8081"));
		app.run(args);
	}

}
