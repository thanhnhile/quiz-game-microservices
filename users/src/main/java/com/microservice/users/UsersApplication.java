package com.microservice.users;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableFeignClients
@OpenAPIDefinition(
		info = @Info(
				title = "Users microservice REST API Documentation",
				description = "Booking microservice REST API Documentation",
				version = "v1"
		),
		externalDocs = @ExternalDocumentation(
				description =  "EazyBank Accounts microservice REST API Documentation",
				url = "https://www.eazybytes.com/swagger-ui.html"
		)
)
public class UsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

}
