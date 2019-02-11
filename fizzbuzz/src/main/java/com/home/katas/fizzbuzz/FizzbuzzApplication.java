package com.home.katas.fizzbuzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class FizzbuzzApplication {
	public static void main(String[] args) {
		SpringApplication.run(FizzbuzzApplication.class, args);
	}
}
