package com.microservice.gatewayserver.fallback;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FallbackController {

    @RequestMapping(value = "/fallback")
    public Mono<Map<String, String>> fallback() {
        Map<String, String> map = new HashMap<>();
        //map.put("serviceName", serviceName);
        map.put("message", "An error occurred. Please try after some time or contact support team " + getSupportTeam("serviceName"));
        return Mono.just(map);
    }

    String getSupportTeam(String serviceName) {
        switch (serviceName) {
            case "users": return "user.support@example.com";
            case "bookings": return"booking.support@example.com";
            case "tickets": return "ticket.support@example.com";
            default: return "0U4QF@example.com";
        }
    }
}
