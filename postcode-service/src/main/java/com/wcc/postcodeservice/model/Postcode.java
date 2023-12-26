package com.wcc.postcodeservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Entity
@Table(name="postcodelatlng")
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class Postcode {

    @Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;

    @Column(unique = true, name = "postcode")
    private String postcode;

    @Column(name="latitude")
    private BigDecimal latitude;

    @Column(name="longitude")
    private BigDecimal longitude;
}
