package com.microservice.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

//http://localhost:8072/webjars/swagger-ui/index.html
@SpringBootApplication
@EnableConfigurationProperties
public class GatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}

	@Bean
	public RouteLocator configRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/users/v3/api-docs")
						.filters(f -> f.rewritePath("/api/users/(?<segment>.*)", "/${segment}")
								.circuitBreaker(config -> config.setName("users-circuit-breaker")
										.setFallbackUri("forward:/fallback"))
						)
						.uri("lb://USERS/v3/api-docs"))
				.route(p -> p.path("/api/users/**")
						.filters(f -> f.rewritePath("/api/users/(?<segment>.*)", "/${segment}"))
						.uri("lb://USERS"))
				.build();
	}
}
