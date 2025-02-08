package com.microservice.users.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class Address {
    @Column(name = "country", nullable = false, length = 50)
    private String city;

    @Column(name = "state", nullable = false, length = 50)
    private String state;

    @Column(name = "street_name", nullable = false, length = 50)
    private String streetName;

    @Column(name = "postal_code", nullable = false, length = 3)
    private String postalCode;
}
