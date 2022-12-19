package com.learning.controller;

import com.learning.entities.Accessory;
import com.learning.entities.Car;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/accessory")
public interface AccessoryController {

    @GetMapping("/{id}")
    Accessory findAccessoryById(@PathVariable Long id);
    @GetMapping("/car-by-accessory/{id}")
    Car findCarById(@PathVariable Long id);
    @GetMapping
    List<Accessory> findAllAccessories();
    @PostMapping
    String createAccessory(@RequestBody Accessory accessory);
    @PutMapping
    String updateAccessoryById(@PathVariable Long id,@RequestBody Accessory accessory);
    @DeleteMapping
    String deleteAccessoryById(@PathVariable Long id);
    @DeleteMapping("/delete-all")
    String deleteAllAccessories();
    @PostMapping("/excel")
    String saveAccessoriesFromExcel();
    @GetMapping("/excel")
    String writeAccessoriesIntoExcel();
}
