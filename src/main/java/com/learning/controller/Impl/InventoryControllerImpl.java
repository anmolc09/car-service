package com.learning.controller.Impl;

import com.learning.controller.InventoryController;
import com.learning.entities.Inventory;
import com.learning.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InventoryControllerImpl implements InventoryController {

    private final InventoryService inventoryService;

    @Override
    public Inventory findInventoryById(Long id) {
            return inventoryService.findInventoryById(id);
    }

    @Override
    public List<Inventory> findAllInventories() {
        return inventoryService.findAllInventories();
    }

    @Override
    public String createInventory(Inventory inventory) {
        inventoryService.createInventory(inventory);
        return String.format("created inventory by id : %s", inventory.getId());
    }

    @Override
    public String updateInventoryById(Long id, Inventory inventory) {
         inventoryService.updateInventoryById(id, inventory);
         return "success";
    }

    @Override
    public String deleteInventoryById(Long id) {
        inventoryService.deleteInventoryById(id);
        return String.format("deleted inventory by id : %s", id);

    }

    @Override
    public String deleteAllInventories() {
        inventoryService.deleteAllInventories();
        return "Deleted all inventories";
    }

    @Override
    public String saveInventoriesFromExcel() {
        inventoryService.saveInventoriesFromExcel();
        return "inventory added to database";
    }

    @Override
    public String writeInventoriesIntoExcel() {
        inventoryService.writeInventoriesIntoExcel();
        return "Added Data ";
    }
}
