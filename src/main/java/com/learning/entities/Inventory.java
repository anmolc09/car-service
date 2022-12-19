package com.learning.entities;

import com.learning.enums.InventoryType;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

@Entity
@Data
@Builder
public class Inventory {
    @Id
    private Long id;
    private String location;
    private InventoryType type;

}
