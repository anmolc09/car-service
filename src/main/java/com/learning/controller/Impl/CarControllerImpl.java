package com.learning.controller.Impl;

import com.learning.controller.CarController;
import com.learning.entities.Car;
import com.learning.entities.Inventory;
import com.learning.exceptions.CarNotFoundException;
import com.learning.exceptions.InventoryNotFoundException;
import com.learning.constants.ExceptionMessage;
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
        return carService.findInventoryById(id)
                .orElseThrow(() -> new InventoryNotFoundException(String.format(ExceptionMessage.INVENTORY_NOT_FOUND,id)));
    }

    @Override
    public Car findCarById(Long id) {
        return carService.findCarById(id)
                .orElseThrow(() ->new CarNotFoundException(String.format(ExceptionMessage.CAR_NOT_FOUND,id)));
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
    public void createCar(Car car) {
        carService.createCar(car);
    }

    @Override
    public void updateCarById(Long id, Car car) {
        carService.updateCarById(id, car);
    }

    @Override
    public void deleteCarById(Long id) {
            carService.deleteCarById(id);
    }

    @Override
    public void deleteAllCars() {
        carService.deleteAllCars();

    }

    @Override
    public void saveCarsFromExcel() {
        carService.saveCarsFromExcel();
    }

    @Override
    public void writeCarsIntoExcel() {
        carService.writeCarsIntoExcel();
    }

}

