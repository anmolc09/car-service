package com.learning.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Builder
public class Accessory {
    @Id
    private Long id;
    private String name;
    private Double price;
    private Long carId;
}
