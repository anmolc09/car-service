package com.learning.controller.Impl;

import com.learning.controller.CarController;
import com.learning.entities.Car;
import com.learning.entities.Inventory;
import com.learning.exceptions.CarNotFoundException;
import com.learning.exceptions.InventoryNotFoundException;
import com.learning.constants.ExceptionMessage;
import com.learning.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

            Comparator<Car> comparator;
            switch (sortBy) {
                case "name" :
                    comparator = (car1, car2) -> car1.getName().compareTo(car2.getName());
                    break;
                case "modelNo":
                    comparator = (car1, car2) -> car1.getModelNo().compareTo(car2.getModelNo());
                    break;
                case "brand":
                    comparator= (car1, car2) -> car1.getBrand().compareTo(car2.getBrand());
                    break;
                default:
                    comparator = (car1, car2) -> car1.getId().compareTo(car2.getId());
            }
            return carService.findAllCars().stream()
                    .sorted(comparator)
                    .collect(Collectors.toList());
    }

    @Override
    public void createCar(Car car) {
        carService.createCar(car);
    }

    @Override
    public Optional<Car> updateCarById(Long id, Car car) {
        return Optional.empty();
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
        carService.writeCarsIntoExcel();
    }

    @Override
    public void writeCarsIntoExcel() {

    }

}

