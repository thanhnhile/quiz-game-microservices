package com.microservice.users.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(
    name = "UserResponseDto",
    description = "User Response Dto"
)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class UserResponseDto {
    @Schema(
            description = "Access Token"
    )
    private String accessToken;
}
