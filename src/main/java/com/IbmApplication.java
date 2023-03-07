package com;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.precarga.PrecargaBD;


@SpringBootApplication
public class IbmApplication {
	@Autowired
	private PrecargaBD myDatabaseSeeder;

	public static void main(String[] args) {
		SpringApplication.run(IbmApplication.class, args);
	}

	@Bean
	InitializingBean seedDatabase() {
		return () -> {
			myDatabaseSeeder.precargarBaseDeDatos();
		};
	}

	@Bean
	GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder().group("springshop-public").packagesToScan("com").build();
	}
}
