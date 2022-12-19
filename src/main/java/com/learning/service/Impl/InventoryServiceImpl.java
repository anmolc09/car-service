package com.learning.service.Impl;

import com.learning.entities.Inventory;
import com.learning.excel.data.reader.InventoryReader;
import com.learning.repository.InventoryRepository;
import com.learning.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final InventoryReader inventoryReader;
    @Override
    public Optional<Inventory> findInventoryById(long id)  {
        return inventoryRepository.findById(id);
    }
    @Override
    public List<Inventory> findAllInventories() {
        return inventoryRepository.findAll();
    }

    @Override
    public void createInventory(Inventory inventory) {
        inventoryRepository.save(inventory);
    }

    @Override
    public Optional<Inventory> updateInventoryById(Long id, Inventory inventory) {
        return Optional.empty();
    }

    @Override
    public void deleteInventoryById(Long id) {
        inventoryRepository.deleteById(id);
    }

    @Override
    public void deleteAllInventories() {
        inventoryRepository.deleteAll();
    }

    @Override
    public void saveInventoriesFromExcel() {
        List<Inventory> inventoryList = null;
        try{
            inventoryList = inventoryReader.getInventoryObjects();
        } catch (IOException ioException) {
            log.error(ioException.getMessage(),ioException);
        }
        inventoryRepository.saveAll(inventoryList);
    }

    @Override
    public void writeInventoriesIntoExcel() {

    }
}
