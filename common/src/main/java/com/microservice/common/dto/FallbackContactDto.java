package com.microservice.common.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "fallback-contact")
@Data
public class FallbackContactDto {
    private String message;

    private ContactDto contactDto;

    List<String> onCallSupport;

    public FallbackContactDto() {

    }
}
