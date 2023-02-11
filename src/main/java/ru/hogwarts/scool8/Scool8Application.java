package ru.hogwarts.scool8;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class Scool8Application {

	public static void main(String[] args) {
		SpringApplication.run(Scool8Application.class, args);
	}

}
