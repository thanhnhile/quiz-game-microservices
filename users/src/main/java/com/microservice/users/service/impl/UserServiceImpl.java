package com.microservice.users.service.impl;

import com.microservice.users.dto.UserCreateDto;
import com.microservice.users.dto.UserResponseDto;
import com.microservice.users.entity.User;
import com.microservice.users.repository.UserRepository;
import com.microservice.users.service.UserService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto createUser(UserCreateDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPhoneNumber(dto.getPhoneNumber());
        userRepository.save(user);
        String accessToken = UUID.randomUUID().toString();
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setAccessToken(accessToken);
        return responseDto;
    }
}
