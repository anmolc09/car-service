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
    public void createInventory(Inventory inventory) {
        inventoryService.createInventory(inventory);
    }

    @Override
    public String updateInventoryById(Long id, Inventory inventory) {
         inventoryService.updateInventoryById(id, inventory);
         return "success";
    }

    @Override
    public void deleteInventoryById(Long id) {
        inventoryService.deleteInventoryById(id);
    }

    @Override
    public void deleteAllInventories() {
        inventoryService.deleteAllInventories();
    }

    @Override
    public void saveInventoriesFromExcel() {
        inventoryService.saveInventoriesFromExcel();
    }

    @Override
    public void writeInventoriesIntoExcel() {
        inventoryService.writeInventoriesIntoExcel();
    }
}
