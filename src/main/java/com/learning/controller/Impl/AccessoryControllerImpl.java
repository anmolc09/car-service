package com.learning.controller.Impl;

import com.learning.controller.AccessoryController;
import com.learning.entities.Accessory;
import com.learning.entities.Car;
import com.learning.service.AccessoryService;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AccessoryControllerImpl implements AccessoryController {

    private final AccessoryService accessoryService;
    @Override
    public Accessory findAccessoryById(Long id) {
        return accessoryService.findAccessoryById(id);
    }

    @Override
    public Car findCarById(Long id) {
        return accessoryService.findCarById(id);
    }

    @Override
    public List<Accessory> findAllAccessories() {
        return accessoryService.findAllAccessories();
    }

    @Override
    public List<Accessory> getAllSortedAccessories(String sortBy) {
        return accessoryService.getAllSortedAccessories(sortBy);
    }

    @Override
    public void createAccessory(Accessory accessory) {
        accessoryService.createAccessory(accessory);
    }

    @Override
    public void updateAccessoryById(Long id, Accessory accessory) {
        accessoryService.updateAccessoryById(id, accessory);
    }

    @Override
    public void deleteAccessoryById(Long id) {
        accessoryService.deleteAccessoryById(id);
    }

    @Override
    public void deleteAllAccessories() {
        accessoryService.deleteAllAccessories();
    }

    @Override
    public void saveAccessoriesFromExcel() {
        accessoryService.saveAccessoriesFromExcel();
    }

    @Override
    public void writeAccessoriesIntoExcel() {
        accessoryService.writeAccessoriesIntoExcel();
    }
}

