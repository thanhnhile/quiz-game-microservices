package com.microservice.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigatewayApplication.class, args);
	}

	@Bean
	public RouteLocator configRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/api/users/**")
						.filters(f -> f.rewritePath("/api/users/(?<segment>.*)", "/${segment}"))
						.uri("lb://USERS"))
				.build();
	}
}
