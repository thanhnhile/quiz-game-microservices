package com.microservice.users.service;

import com.microservice.users.dto.UserCreateDto;
import com.microservice.users.dto.UserProfileCreateDto;
import com.microservice.users.dto.UserProfileResponseDto;
import com.microservice.users.dto.UserResponseDto;

public interface UserService {
    UserResponseDto createUser (UserCreateDto dto);

    UserProfileResponseDto createUserProfile(UserProfileCreateDto dto);
}
