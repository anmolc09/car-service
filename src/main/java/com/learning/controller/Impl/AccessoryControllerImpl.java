package com.learning.controller.Impl;

import com.learning.controller.AccessoryController;
import com.learning.entities.Accessory;
import com.learning.entities.Car;
import com.learning.service.AccessoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public String createAccessory(Accessory accessory) {
        accessoryService.createAccessory(accessory);
        return "Accessory added successfully";
    }

    @Override
    public String updateAccessoryById(Long id, Accessory accessory) {
        accessoryService.updateAccessoryById(id, accessory);
        return "Updated Successfully";
    }

    @Override
    public String deleteAccessoryById(Long id) {

        accessoryService.deleteAccessoryById(id);
        return "Deleted Accessory";
    }

    @Override
    public String deleteAllAccessories() {
        accessoryService.deleteAllAccessories();
        return "All Accessories Deleted";
    }

    @Override
    public String saveAccessoriesFromExcel() {
        accessoryService.saveAccessoriesFromExcel();
        return "Accessories saved in database";
    }

    @Override
    public String writeAccessoriesIntoExcel() {
        accessoryService.writeAccessoriesIntoExcel();
        return "Accessories added in excel";
    }
}

