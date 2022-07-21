package com.adrish.spring.boot.employee.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class EmployeeRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRestApplication.class, args);
	}
}