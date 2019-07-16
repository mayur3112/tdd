package com.example.testDriven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.testDriven"})
public class TestDrivenApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestDrivenApplication.class, args);
	}

}
