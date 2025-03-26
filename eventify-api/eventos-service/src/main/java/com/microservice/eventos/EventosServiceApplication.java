package com.microservice.eventos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EventosServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventosServiceApplication.class, args);
	}

}
