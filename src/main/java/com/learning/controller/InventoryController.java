package com.learning.controller;

import com.learning.entities.Inventory;
import com.learning.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{id}")
    public Inventory findInventoryById(@PathVariable Long id) {
            return inventoryService.findInventoryById(id);
    }

    @GetMapping
    public List<Inventory> findAllInventories() {
        return inventoryService.findAllInventories();
    }

    @PostMapping
    public String createInventory(@RequestBody Inventory inventory) {
        inventoryService.createInventory(inventory);
        return String.format("created inventory by id : %s", inventory.getId());
    }

    @PutMapping
    public String updateInventoryById(@PathVariable Long id, @RequestBody Inventory inventory) {
         inventoryService.updateInventoryById(id, inventory);
         return "success";
    }

    @DeleteMapping("/{id}")
    public String deleteInventoryById(@PathVariable Long id) {
        inventoryService.deleteInventoryById(id);
        return String.format("deleted inventory by id : %s", id);

    }

    @DeleteMapping("/delete-all")
    public String deleteAllInventories() {
        inventoryService.deleteAllInventories();
        return "Deleted all inventories";
    }

    @PostMapping("/excel")
    public String saveInventoriesFromExcel() {
        inventoryService.saveInventoriesFromExcel();
        return "inventory added to database";
    }

    @GetMapping("/excel")
    public String writeInventoriesIntoExcel() {
        inventoryService.writeInventoriesIntoExcel();
        return "Added Data ";
    }
}
