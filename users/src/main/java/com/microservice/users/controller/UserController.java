package com.microservice.users.controller;

import com.microservice.users.dto.UserCreateDto;
import com.microservice.users.dto.UserResponseDto;
import com.microservice.users.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/register")
    public UserResponseDto createUser(@RequestBody UserCreateDto dto) {
        return userService.createUser(dto);
    }
}
