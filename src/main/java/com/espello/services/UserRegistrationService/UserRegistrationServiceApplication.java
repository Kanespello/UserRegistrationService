package com.espello.services.UserRegistrationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.espello"})
@SpringBootApplication
public class UserRegistrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRegistrationServiceApplication.class, args);
	}
}
