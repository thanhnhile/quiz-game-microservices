package com.microservice.users.controller;

import com.microservice.common.dto.FallbackContactDto;
import com.microservice.users.dto.UserCreateDto;
import com.microservice.users.dto.UserResponseDto;
import com.microservice.users.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Tag(
        name = "CRUD REST APIs for Users",
        description = "CRUD REST APIs to CREATE, UPDATE, FETCH AND DELETE user details"
)
@Validated
@RestController
@RequestMapping()
public class UserController{

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Value("${version}")
    private String version;

    private final UserService userService;

    private final FallbackContactDto fallbackContactDto;

    public UserController(UserService userService, FallbackContactDto fallbackContactDto) {
        this.userService = userService;
        this.fallbackContactDto = fallbackContactDto;
    }


    @GetMapping("/version")
    public String getVersion(){
        return version;
    }

    @Operation(
            summary = "Create User REST API",
            description = "REST API to create new User"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            )
    }
    )
    @PostMapping("/register")
    public UserResponseDto createUser(@RequestBody @Valid UserCreateDto dto, @RequestHeader("correlation-id") String correlationId) {
        logger.debug("Creating User with CorrelationId: " + correlationId);
        return userService.createUser(dto);
    }

    @GetMapping("/fallback")
    public FallbackContactDto fallback(){
        return fallbackContactDto;
    }
}
