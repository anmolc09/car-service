package com.learning.controller;

import com.learning.entities.Inventory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/inventory")
public interface InventoryController {

    @GetMapping("/{id}")
    Inventory findInventoryById(Long id);
    @GetMapping
    List<Inventory> findAllInventories();
    @PostMapping
    String createInventory(@RequestBody Inventory inventory);
    @PutMapping
    String updateInventoryById(@PathVariable Long id,@RequestBody Inventory inventory);
    @DeleteMapping("/{id}")
    String deleteInventoryById(@PathVariable Long id);
    @DeleteMapping("/delete-all")
    String deleteAllInventories();
    @PostMapping("/excel")
    String saveInventoriesFromExcel();
   @GetMapping("/excel")
    String writeInventoriesIntoExcel();

}
