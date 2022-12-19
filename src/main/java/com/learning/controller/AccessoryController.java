package com.learning.controller;

import com.learning.entities.Accessory;
import com.learning.entities.Car;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/accessory")
public interface AccessoryController {

    @GetMapping("/{id}")
    Accessory findAccessoryById(@PathVariable Long id);

    @GetMapping("/car-by-accessory/{id}")
    Optional<Car> findCarById(@PathVariable Long id);
    @GetMapping
    List<Accessory> findAllAccessories();
    @GetMapping("/sort")
    List<Accessory> getAllSortedAccessories(@RequestParam(value ="sortBy", required = false, defaultValue = "") String sortBy);
    @PostMapping
    void createAccessory(@RequestBody Accessory accessory);
    @PutMapping
    Optional<Accessory> updateAccessoryById(@PathVariable Long id,@RequestBody Accessory accessory);
    @DeleteMapping
    void deleteAccessoryById(@PathVariable Long id);
    @DeleteMapping
    void deleteAllAccessories();
    @PostMapping("/excel")
    void saveAccessoriesFromExcel();
    @GetMapping("/excel")
    void writeAccessoriesIntoExcel();

}
