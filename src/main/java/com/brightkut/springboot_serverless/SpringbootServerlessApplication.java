package com.brightkut.springboot_serverless;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
// @Import({ HelloController.class })
public class SpringbootServerlessApplication {
        public static void main(String[] args) {
		SpringApplication.run(SpringbootServerlessApplication.class, args);
	}
}
