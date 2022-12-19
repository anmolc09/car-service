package com.learning.service.Impl;

import com.learning.constants.ExceptionMessage;
import com.learning.entities.Car;
import com.learning.entities.Inventory;
import com.learning.excel.data.reader.CarReader;
import com.learning.excel.data.writer.CarWriter;
import com.learning.exceptions.CarNotFoundException;
import com.learning.exceptions.InventoryNotFoundException;
import com.learning.repository.CarRepository;
import com.learning.service.CarService;
import com.learning.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    private final InventoryService inventoryService;
    private final CarReader carReader;
    private final CarWriter carWriter;
    private final XSSFWorkbook xssfWorkbook;

    @Override
    public Optional<Car> findCarById(long id) {
        return carRepository.findById(id);
    }

    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> findAllSortedCars(String sortBy) {
        Comparator<Car> comparator;

        switch (sortBy) {
            case "name":
                comparator = (car1, car2) -> car1.getName().compareTo(car2.getName());
                break;
            case "modelNo":
                comparator = (car1, car2) -> car1.getModelNo().compareTo(car2.getModelNo());
                break;
            case "brand":
                comparator = (car1, car2) -> car1.getBrand().compareTo(car2.getBrand());
                break;
            default:
                comparator = (car1, car2) -> car1.getId().compareTo(car2.getId());
        }
        return carRepository.findAll().stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    @Override
    public void createCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void updateCarById(Long id, Car car) {
        if(carRepository.existsById(id)){
            carRepository.save(car);
            log.info(String.format("Successfully update Car with id %s", id));
        } else {
            log.error(String.format(ExceptionMessage.CAR_NOT_FOUND, id));
        }
    }

    @Override
    public void deleteCarById(Long id) {
        if(carRepository.existsById(id)) {
            carRepository.deleteById(id);
            log.info(String.format("Successfully deleted Car with id %s", id));
        } else {
            log.error(String.format(ExceptionMessage.CAR_NOT_FOUND, id));
        }
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
        try{
            carWriter.createCarsheet(xssfWorkbook, findAllCars());
        }catch(IOException exception) {
            log.error(exception.getMessage());
        }
    }
}
