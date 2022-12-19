package com.learning.controller.Impl;

import com.learning.constants.ExceptionMessage;
import com.learning.controller.AccessoryController;
import com.learning.entities.Accessory;
import com.learning.entities.Car;
import com.learning.exceptions.AccessoryNotFoundException;
import com.learning.service.AccessoryService;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AccessoryControllerImpl implements AccessoryController {

    private final AccessoryService accessoryService;
    @Override
    public Accessory findAccessoryById(Long id) {
        return accessoryService.findAccessoryById(id)
                .orElseThrow(() -> new AccessoryNotFoundException(String.format(ExceptionMessage.ACCESSORY_NOT_FOUND,id)));
    }

    @Override
    public Optional<Car> findCarById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Accessory> findAllAccessories() {
        return accessoryService.findAllAccessories();
    }

    @Override
    public List<Accessory> getAllSortedAccessories(String sortBy) {
        return null;
    }

    @Override
    public void createAccessory(Accessory accessory) {
        accessoryService.createAccessory(accessory);
    }

    @Override
    public Optional<Accessory> updateAccessoryById(Long id, Accessory accessory) {
        return Optional.empty();
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

    }
}

