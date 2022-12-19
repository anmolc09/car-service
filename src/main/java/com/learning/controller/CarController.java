package com.learning.controller;

import com.learning.entities.Car;
import com.learning.entities.Inventory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    String createCar(@RequestBody Car car);
    @PutMapping
    String updateCarById(@PathVariable Long id, @RequestBody Car car);
    @DeleteMapping
    String deleteCarById(@PathVariable Long id);
    @DeleteMapping("/delete-all")
    String deleteAllCars();

    // TODO: enhance with multipart api in future
    @PostMapping("/excel")
    String saveCarsFromExcel();
    @GetMapping("/excel")
    String writeCarsIntoExcel();
}
