package com.learning.service;

import com.learning.entities.Inventory;

import java.util.List;

public interface InventoryService {
    Inventory findInventoryById(long id);
    List<Inventory> findAllInventories();
    void createInventory(Inventory inventory);
    void updateInventoryById(Long id, Inventory inventory);
    void deleteInventoryById(Long id);
    void deleteAllInventories();
    void saveInventoriesFromExcel();
    void writeInventoriesIntoExcel();

}
