package com.target.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApacheKafka01Application {

	public static void main(String[] args) {
		SpringApplication.run(ApacheKafka01Application.class, args);
		System.out.println("test kafka start");
	}

}
