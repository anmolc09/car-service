package com.learning.controller;

import com.learning.entities.Car;
import com.learning.entities.Inventory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/car")
public interface CarController {

    @GetMapping("/inventory-by-car/{id}")
    Inventory findInventoryById(@PathVariable Long id );
    @GetMapping("/{id}")
    Car findCarById(@PathVariable Long id);
    @GetMapping("/all-cars")
    List<Car> findAllCars();
    @GetMapping("/sort")
    List<Car> findAllSortedCars(@RequestParam(value ="sortBy", required = false, defaultValue = "") String sortBy);
    @PostMapping
    void createCar(@RequestBody Car car);
    @PutMapping
    void updateCarById(@PathVariable Long id, @RequestBody Car car);
    @DeleteMapping
    void deleteCarById(@PathVariable Long id);
    @DeleteMapping("/delete-all")
    void deleteAllCars();
    @PostMapping("/excel")
    void saveCarsFromExcel();
    @GetMapping("/excel")
    void writeCarsIntoExcel();
}
