package com.microservice.users.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_name", nullable = false)
    private String username;

    @Column(name="phone_number", nullable = false, length = 10)
    private String phoneNumber;

    //dang nhap/dang xuat use keycloak,session for user, use api gateway
}
