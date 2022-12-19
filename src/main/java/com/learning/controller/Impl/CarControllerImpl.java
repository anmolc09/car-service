package com.learning.controller.Impl;

import com.learning.controller.CarController;
import com.learning.entities.Car;
import com.learning.entities.Inventory;
import com.learning.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarControllerImpl implements CarController {

    private final CarService carService;

    @Override
    public Inventory findInventoryById(Long id) {
        return carService.findInventoryById(id);
    }

    @Override
    public Car findCarById(Long id) {
        return carService.findCarById(id);
    }

    @Override
    public List<Car> findAllCars() {
        return carService.findAllCars();
    }

    @Override
    public List<Car> findAllSortedCars(String sortBy) {
        return carService.findAllSortedCars(sortBy);
    }

    @Override
    public String createCar(Car car) {
        carService.createCar(car);
        return "Car created successfully";
    }

    @Override
    public String updateCarById(Long id, Car car) {
        carService.updateCarById(id, car);
        return String.format("updated car with id: %s ", id);
    }

    @Override
    public String deleteCarById(Long id) {
            carService.deleteCarById(id);
            return String.format("Deleted car by id: %s", id);
    }

    @Override
    public String deleteAllCars() {
        carService.deleteAllCars();
        return "Deleted all Cars";
    }

    @Override
    public String saveCarsFromExcel() {
        carService.saveCarsFromExcel();
        return "Cars added to Database";
    }

    @Override
    public String writeCarsIntoExcel() {
        carService.writeCarsIntoExcel();
        return "Cars  added to excel";
    }

}

