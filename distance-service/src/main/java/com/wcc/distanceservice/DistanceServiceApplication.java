package com.wcc.distanceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DistanceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistanceServiceApplication.class, args);
	}

}
