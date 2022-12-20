package com.learning.controller;

import com.learning.entities.Car;
import com.learning.entities.Inventory;
import com.learning.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    @GetMapping("/inventory-by-car/{id}")
    public Inventory findInventoryById(@PathVariable Long id) {
        return carService.findInventoryById(id);
    }

    @GetMapping("/{id}")
    public Car findCarById(@PathVariable Long id) {
        return carService.findCarById(id);
    }

    @GetMapping("/all-cars")
    public List<Car> findAllCars() {
        return carService.findAllCars();
    }

    @GetMapping("/sort")
    public List<Car> findAllSortedCars(@RequestParam(value ="sortBy", required = false, defaultValue = "") String sortBy) {
        return carService.findAllSortedCars(sortBy);
    }

    @PostMapping
    public String createCar(@RequestBody Car car) {
        carService.createCar(car);
        return "Car created successfully";
    }

    @PutMapping
    public String updateCarById(@PathVariable Long id, @RequestBody Car car) {
        carService.updateCarById(id, car);
        return String.format("updated car with id: %s ", id);
    }

    @DeleteMapping
    public String deleteCarById(@PathVariable Long id) {
            carService.deleteCarById(id);
            return String.format("Deleted car by id: %s", id);
    }

    // TODO: enhance with multipart api in future
    @DeleteMapping("/delete-all")
    public String deleteAllCars() {
        carService.deleteAllCars();
        return "Deleted all Cars";
    }

    @PostMapping("/excel")
    public String saveCarsFromExcel() {
        carService.saveCarsFromExcel();
        return "Cars added to Database";
    }

    @GetMapping("/excel")
    public String writeCarsIntoExcel() {
        carService.writeCarsIntoExcel();
        return "Cars  added to excel";
    }

}

