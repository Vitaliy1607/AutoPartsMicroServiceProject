package com.dto.dtomanager.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty(value = "first_name")
    private String firstName;
    @JsonProperty(value = "last_name")
    private String lastName;
    @JsonProperty(value = "telephone_number")
    private Long telephoneNumber;
    private String email;
    @JsonProperty(value = "sex_type")
    private String sexType;

    private String password;

    @JsonProperty(value = "is_deleted")
    private boolean isDeleted;
}
