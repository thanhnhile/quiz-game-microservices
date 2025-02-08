package com.microservice.users.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "UserProfileCreateDto", description = "User Profile Create DTO")
public class UserProfileCreateDto {
    @Schema(description="User's email", example = "0U4QF@example.com", required = true)
    private String email;

    @Schema(description="User's first name", example = "John", required = true)
    private String firstName;

    @Schema(description = "User's last name", example = "Doe", required = true)
    private String lastName;

    @Schema(name="name", required = true)
    private AddressDto address;

    @Getter @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name="AddressDto")
    public static class AddressDto {
        @Schema(name="City", example = "Ho Chi Minh City", required = true)
        private String city;

        @Schema(name="State", example = "abc", required = true)
        private String state;

        @Schema(name="Street Name", example = "abc", required = true)
        private String streetName;

        @Schema(name="Postal Code", example = "434", required = true)
        private String postalCode;
    }
}
