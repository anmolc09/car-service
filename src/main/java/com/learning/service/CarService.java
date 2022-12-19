package com.learning.service;

import com.learning.entities.Car;
import com.learning.entities.Inventory;

import java.util.List;
import java.util.Optional;

public interface CarService {

    Optional<Car> findCarById(long id);
    List<Car> findAllCars();
    List<Car> findAllSortedCars(String sortBy);
    void createCar(Car car);
    Optional<Car> updateCarById(Long id, Car car);
    void deleteCarById(Long id);
    void deleteAllCars();
    Optional<Inventory> findInventoryById(long id);
    void saveCarsFromExcel();
    void writeCarsIntoExcel();

}
