package com.learning.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Builder
public class Car {

    @Id
    private Long id;
    private String name;
    private String brand;
    private Long modelNo;
    private Long inventoryId;
}
