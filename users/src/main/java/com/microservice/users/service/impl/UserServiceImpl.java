package com.microservice.users.service.impl;

import com.microservice.users.dto.UserCreateDto;
import com.microservice.users.dto.UserProfileCreateDto;
import com.microservice.users.dto.UserProfileResponseDto;
import com.microservice.users.dto.UserResponseDto;
import com.microservice.users.entity.User;
import com.microservice.users.entity.UserProfile;
import com.microservice.users.mapper.UserProfileMapper;
import com.microservice.users.repository.UserProfileRepository;
import com.microservice.users.repository.UserRepository;
import com.microservice.users.service.UserService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserProfileRepository userProfileRepository;

    private final UserProfileMapper userProfileMapper;

    public UserServiceImpl(UserRepository userRepository, UserProfileRepository userProfileRepository, UserProfileMapper userProfileMapper) {
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
        this.userProfileMapper = userProfileMapper;
    }

    @Override
    public UserResponseDto createUser(UserCreateDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setPassword(dto.getPassword());
        userRepository.save(user);
        String accessToken = UUID.randomUUID().toString();
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setAccessToken(accessToken);
        return responseDto;
    }

    @Override
    public UserProfileResponseDto createUserProfile(UserProfileCreateDto dto) {
        UserProfile userProfile = userProfileMapper.mapUserProfileDtoToUserProfile(dto);
        //userProfile.setUser();
        return userProfileMapper.mapUserProfileToUserProfileResponseDto(userProfileRepository.save(userProfile));
    }
}
