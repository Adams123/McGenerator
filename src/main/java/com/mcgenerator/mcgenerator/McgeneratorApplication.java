package com.mcgenerator.mcgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan
public class McgeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(McgeneratorApplication.class, args);
	}

}

