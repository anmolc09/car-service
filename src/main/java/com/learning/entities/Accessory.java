package com.learning.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Builder
@Table(name = "accessory")
public class Accessory {
    @Id
    private Long id;
    private String name;
    private Double price;
    private Long carId;
}
