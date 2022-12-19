package com.learning.entities;

import com.learning.enums.InventoryType;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Builder
@Table(name = "inventory")
public class Inventory {
    @Id
    private Long id;
    private String location;
    @Enumerated(EnumType.STRING)
    private InventoryType type;

}
