package com.microservice.gatewayserver;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

//http://localhost:8072/webjars/swagger-ui/index.html
@SpringBootApplication
@EnableConfigurationProperties
@OpenAPIDefinition(
		info = @Info(
				title = "API Gateway Documentation",
				description = "Booking microservice REST API Documentation",
				version = "v1"
		)
)
public class GatewayServerApplication {

	private static Logger logger = LoggerFactory.getLogger(GatewayServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}

	@Bean
	public RouteLocator configRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/users/**")
						.filters(f -> f.rewritePath("/users/(?<segment>.*)", "/${segment}")
								.circuitBreaker(config -> config.setName("users-circuit-breaker")
										.setFallbackUri("forward:/fallback"))
						)

						.uri("lb://USERS"))
				.route(p -> p.path("/api/users/**")
						.filters(f -> f.rewritePath("/api/users/(?<segment>.*)", "/${segment}")
								.circuitBreaker(config -> config.setName("users-circuit-breaker")
										.setFallbackUri("forward:/fallback")))
						.uri("lb://USERS"))
				.route(p -> p.path("/bookings/**")
						.filters(f -> f.rewritePath("/bookings/(?<segment>.*)", "/${segment}")
						)
						.uri("lb://TICKETS"))
				.route(p -> p.path("/api/bookings/**")
						.filters(f -> f.rewritePath("/api/bookings/(?<segment>.*)", "/${segment}")
								.circuitBreaker(config -> config.setName("bookings-circuit-breaker")
										.setFallbackUri("forward:/fallback?service-name=bookings")))
						.uri("lb://TICKETS"))
				.build();
	}
}
