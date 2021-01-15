package com.dto.dtomanager.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartsDTO implements Serializable {

    private Long id;

    @JsonProperty(value = "part_name")
    private String partName;

    private String condition;   //show this detail was used or new

    private BigDecimal price;

    @JsonProperty(value = "user_id")
    private Long userId;

    @JsonProperty(value = "user_dto")
    private UserDTO userDTO;
}
