package com.learning.service;

import com.learning.entities.Car;
import com.learning.entities.Inventory;

import java.util.List;

public interface CarService {

    Car findCarById(long id);
    List<Car> findAllCars();
    List<Car> findAllSortedCars(String sortBy);
    void createCar(Car car);
    void updateCarById(Long id, Car car);
    void deleteCarById(Long id);
    void deleteAllCars();
    Inventory findInventoryById(long id);
    void saveCarsFromExcel();
    void writeCarsIntoExcel();

}
