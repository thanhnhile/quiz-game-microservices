package com.microservice.users.controller;

import com.microservice.users.dto.UserCreateDto;
import com.microservice.users.dto.UserResponseDto;
import com.microservice.users.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "CRUD REST APIs for Users",
        description = "CRUD REST APIs to CREATE, UPDATE, FETCH AND DELETE user details"
)
@Validated
@RestController
@RequestMapping()
public class UserController {

    @Value("${version}")
    private String version;

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
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
    public UserResponseDto createUser(@RequestBody @Valid UserCreateDto dto) {
        return userService.createUser(dto);
    }
}
