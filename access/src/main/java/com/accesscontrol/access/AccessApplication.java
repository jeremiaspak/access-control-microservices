package com.accesscontrol.access;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AccessApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessApplication.class, args);
	}
}
