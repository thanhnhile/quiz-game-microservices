package com.microservice.users;

import com.microservice.common.dto.FallbackContactDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {
    @Bean
    public FallbackContactDto fallbackContactDto(){
        return new FallbackContactDto();
    }
}
