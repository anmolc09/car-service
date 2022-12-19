package com.learning.service;

import com.learning.entities.Accessory;
import com.learning.entities.Car;

import java.util.List;

public interface AccessoryService {

    Accessory findAccessoryById(long id);
    Car findCarById(long id);
    List<Accessory> findAllAccessories();
    void createAccessory(Accessory accessory);
    void updateAccessoryById(Long id, Accessory accessory);
    void deleteAccessoryById(Long id);
    void deleteAllAccessories();
    void saveAccessoriesFromExcel();
    void writeAccessoriesIntoExcel();
}

