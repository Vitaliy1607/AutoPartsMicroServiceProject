package com.parts.userrestapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class PartsDTO {

    private Long id;

    @JsonProperty(value = "part_name")
    private String partName;

    private String condition;   //show this detail was used or new

    private BigDecimal price;
}
