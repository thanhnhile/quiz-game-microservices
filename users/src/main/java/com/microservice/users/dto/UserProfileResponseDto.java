package com.microservice.users.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(name="UserProfileResponseDto", description = "User Profile Response DTO")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class UserProfileResponseDto {
    @Schema(description="User's email", example = "0U4QF@example.com", required = true)
    private String email;

    @Schema(description="User's first name", example = "John", required = true)
    private String firstName;

    @Schema(description = "User's last name", example = "Doe", required = true)
    private String lastName;

    private UserProfileCreateDto.AddressDto address;

}
