package com.learning.controller;

import com.learning.entities.Inventory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/inventory")
public interface InventoryController {

    @GetMapping("/{id}")
    Inventory findInventoryById(long id);
    @GetMapping
    List<Inventory> findAllInventories();
    @PostMapping
    void createInventory(@RequestBody Inventory inventory);
    @PutMapping
    String updateInventoryById(@PathVariable Long id,@RequestBody Inventory inventory);
    @DeleteMapping("/{id}")
    void deleteInventoryById(@PathVariable Long id);
    @DeleteMapping("/delete-all")
    void deleteAllInventories();
    @PostMapping("/excel")
    void saveInventoriesFromExcel();
   @GetMapping("/excel")
    void writeInventoriesIntoExcel();

}
