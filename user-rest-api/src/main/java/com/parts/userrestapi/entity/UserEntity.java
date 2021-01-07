package com.parts.userrestapi.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name",nullable = false, length = 75)
    private String firstName;

    @Column(name = "last_name",nullable = false, length = 75)
    private String lastName;

    @Column(name = "telephone_number", length = 10)
    private Long telephoneNumber;

    @Column(nullable = false, unique = true , length = 150)
    private String email;

    @Column(unique = true, length = 40)
    private String login;

    @Column(nullable = false)
    private String sexType;

    private String role;

    private String password;
}