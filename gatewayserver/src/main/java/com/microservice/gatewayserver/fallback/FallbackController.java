package com.microservice.gatewayserver.fallback;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FallbackController {

    @RequestMapping("/fallback")
    public Mono<Map<String, String>> fallback() {
        Map<String, String> map = new HashMap<>();
        map.put("message", "fallback");
        return Mono.just(map);
    }
}
