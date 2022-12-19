package com.learning.service.Impl;

import com.learning.constants.ExceptionMessage;
import com.learning.entities.Car;
import com.learning.entities.Inventory;
import com.learning.excel.data.reader.CarReader;
import com.learning.exceptions.CarNotFoundException;
import com.learning.exceptions.InventoryNotFoundException;
import com.learning.repository.CarRepository;
import com.learning.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * this is car service implementation
 *
 * @author anmol
 * @since November 2022
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final InventoryServiceImpl inventoryService;
    private final CarReader carReader;

    @Override
    public Optional<Car> findCarById(long id) {
        return carRepository.findById(id);
    }

    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> findAllSortedCars(String sortBy) {
        return null;
    }

    @Override
    public void createCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public Optional<Car> updateCarById(Long id, Car car) {
        return Optional.empty();
    }

    @Override
    public void deleteCarById(Long id) {
        carRepository.deleteById(id);

    }

    @Override
    public void deleteAllCars() {
        carRepository.deleteAll();
    }

    @Override
    public Optional<Inventory> findInventoryById(long id) {
        return Optional.ofNullable(inventoryService.findInventoryById(findCarById(id)
                .orElseThrow(() -> new CarNotFoundException(ExceptionMessage.CAR_NOT_FOUND + id))
                .getInventoryId())
                .orElseThrow(() -> new InventoryNotFoundException(ExceptionMessage.INVENTORY_NOT_FOUND + id)));
    }

    @Override
    public void saveCarsFromExcel() {
        List<Car> carList = null;
        try {
            carList = carReader.getCarObjects();
        } catch (IOException ioException) {
            log.error(ioException.getMessage());
        }
        carRepository.saveAll(carList);
    }

    @Override
    public void writeCarsIntoExcel() {

    }
}
