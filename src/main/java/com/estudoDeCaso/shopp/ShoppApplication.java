package com.estudoDeCaso.shopp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.estudoDeCaso.shopp.repositories")
@EntityScan(basePackages = "com.estudoDeCaso.shopp.entities")
public class ShoppApplication {

	public static void main(String[] args) {

		SpringApplication.run(ShoppApplication.class, args);
	}
}
