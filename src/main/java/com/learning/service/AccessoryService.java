package com.learning.service;

import com.learning.entities.Accessory;
import com.learning.entities.Car;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface AccessoryService {

    Optional<Accessory> findAccessoryById(long id);
    Optional<Car> findCarById(long id);
    List<Accessory> findAllAccessories();
    List<Accessory> getAllSortedAccessories(String sortBy);
    void createAccessory(Accessory accessory);
    void updateAccessoryById(Long id, Accessory accessory);
    void deleteAccessoryById(Long id);
    void deleteAllAccessories();
    void saveAccessoriesFromExcel();
    void writeAccessoriesIntoExcel();
}

