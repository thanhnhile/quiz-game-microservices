package com.microservice.users.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;


@Schema(name = "UserCreateDto", description = "DTO for creating a new user")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class UserCreateDto {
    @Schema(description = "User name", example = "John Doe")
    @NotEmpty(message = "User name cannot be empty")
    private String username;

    @Schema(description = "User phone number", example = "1234567890")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phoneNumber;
}
