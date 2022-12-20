package com.learning.controller;

import com.learning.entities.Accessory;
import com.learning.entities.Car;
import com.learning.service.AccessoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/accessory")
@RequiredArgsConstructor
public class AccessoryController {

    private final AccessoryService accessoryService;
    @GetMapping("/{id}")
    public Accessory findAccessoryById(@PathVariable Long id) {
        return accessoryService.findAccessoryById(id);
    }

    @GetMapping("/car-by-accessory/{id}")
    public Car findCarById(@PathVariable Long id) {
        return accessoryService.findCarById(id);
    }

    @GetMapping
    public List<Accessory> findAllAccessories() {
        return accessoryService.findAllAccessories();
    }

    @PostMapping
    public String createAccessory(@RequestBody Accessory accessory) {
        accessoryService.createAccessory(accessory);
        return "Accessory added successfully";
    }

    @PutMapping
    public String updateAccessoryById(@PathVariable Long id, @RequestBody Accessory accessory) {
        accessoryService.updateAccessoryById(id, accessory);
        return "Updated Successfully";
    }

    @DeleteMapping
    public String deleteAccessoryById(@PathVariable Long id) {
        accessoryService.deleteAccessoryById(id);
        return "Deleted Accessory";
    }

    @DeleteMapping("/delete-all")
    public String deleteAllAccessories() {
        accessoryService.deleteAllAccessories();
        return "All Accessories Deleted";
    }

    @PostMapping("/excel")
    public String saveAccessoriesFromExcel() {
        accessoryService.saveAccessoriesFromExcel();
        return "Accessories saved in database";
    }

    @GetMapping("/excel")
    public String writeAccessoriesIntoExcel() {
        accessoryService.writeAccessoriesIntoExcel();
        return "Accessories added in excel";
    }
}

