package com.learning.service.Impl;

import com.learning.constants.ExceptionMessage;
import com.learning.entities.Inventory;
import com.learning.excel.data.reader.InventoryReader;
import com.learning.excel.data.writer.InventoryWriter;
import com.learning.exceptions.InventoryNotFoundException;
import com.learning.repository.InventoryRepository;
import com.learning.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
    private final InventoryWriter writer;
    private final XSSFWorkbook xssfWorkbook;
    @Override
    public Inventory findInventoryById(long id)  {
        return inventoryRepository.findById(id)
                .orElseThrow(() -> new InventoryNotFoundException(String.format(ExceptionMessage.INVENTORY_NOT_FOUND, id)));
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
    public void updateInventoryById(Long id, Inventory inventory) {
        if(inventoryRepository.existsById(id)) {
        inventoryRepository.save(inventory);
        log.info(String.format("Successfully updated Inventory with id %s", id));
         } else {
                 log.error(String.format(ExceptionMessage.INVENTORY_NOT_FOUND, id));
        }
    }

    @Override
    public void deleteInventoryById(Long id) {
        if(inventoryRepository.existsById(id)) {
            inventoryRepository.deleteById(id);
            log.info(String.format("Successfully deleted Inventory with id %s", id));
        } else {
            log.error(String.format(ExceptionMessage.INVENTORY_NOT_FOUND, id));
        }
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
        try {
            writer.createInventorysheet(xssfWorkbook, findAllInventories());
        } catch(IOException exception) {
            log.error(exception.getMessage());
        }
    }
}
