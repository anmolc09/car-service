package com.learning.controller.Impl;

import com.learning.constants.ExceptionMessage;
import com.learning.controller.InventoryController;
import com.learning.entities.Inventory;
import com.learning.exceptions.InventoryNotFoundException;
import com.learning.service.Impl.InventoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class InventoryControllerImpl implements InventoryController {

    private final InventoryServiceImpl inventoryService;

    @Override
    public Inventory findInventoryById(long id) {
        return inventoryService.findInventoryById(id)
                .orElseThrow(() -> new InventoryNotFoundException(String.format(ExceptionMessage.INVENTORY_NOT_FOUND,id)));
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

    }
}
