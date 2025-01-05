package com.microservice.users.service;

import com.microservice.users.dto.UserCreateDto;
import com.microservice.users.dto.UserResponseDto;

public interface UserService {
    UserResponseDto createUser (UserCreateDto dto);
}
