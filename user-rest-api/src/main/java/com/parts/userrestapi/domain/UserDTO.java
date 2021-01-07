package com.parts.userrestapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    private String firstName;
    private String lastName;
    private Long telephoneNumber;
    private String email;
    private String sexType;

    private String password;
    private String passwordConfirm;
}
