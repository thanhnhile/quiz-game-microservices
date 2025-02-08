package com.microservice.users.controller;

import com.microservice.common.dto.FallbackContactDto;
import com.microservice.users.dto.UserCreateDto;
import com.microservice.users.dto.UserProfileCreateDto;
import com.microservice.users.dto.UserProfileResponseDto;
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

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(
            summary = "Create User REST API",
            description = "REST API to create new user"
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

    @Operation(
            summary = "Create User Profile REST API",
            description = "REST API to create user profile"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            )
    }
    )
    @PostMapping("/create-profile")
    public UserProfileResponseDto createUserProfile(@RequestBody @Valid UserProfileCreateDto dto) {
        return userService.createUserProfile(dto);
    }

}
