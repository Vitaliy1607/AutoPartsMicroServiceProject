package com.parts.partsrestapi.entity;

import com.parts.partsrestapi.domain.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "parts")
public class PartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "part_name",nullable = false, length = 50)
    private String partName;

    @Column(nullable = false, length = 25)
    private String condition;   //show this detail was used or new

    @Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0")
    private BigDecimal price;

    @Column(name = "user_id")
    private Long userId;
}
