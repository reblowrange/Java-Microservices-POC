package com.promicroprice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = {"com.controllers", "com.services"})
@EnableEurekaClient
public class ProMicroPriceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProMicroPriceApplication.class, args);
	}

}
