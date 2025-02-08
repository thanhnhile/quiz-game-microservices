package com.microservice.users.service.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "keycloak", url = "http://localhost:8090")
public interface AdminKeyCloakClient {

}
