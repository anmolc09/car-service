package com.learning.excel.data.reader;

import com.learning.entities.Car;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class CarReader {

    public List<Car> getCarObjects() throws IOException {
        FileInputStream file = new FileInputStream(new File(".\\resources\\data.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        XSSFSheet sheet = workbook.getSheetAt(1);

        List<Car> carList = new ArrayList<>();

        getCarList(sheet, carList);

        file.close();

        return carList;
    }

    private static void getCarList(XSSFSheet sheet, List<Car> carList) {
        for (int index = sheet.getFirstRowNum() + 1; index <= sheet.getLastRowNum(); index++) {
            Row row = sheet.getRow(index);
            Car car = Car.builder().build();

            for (int index2 = row.getFirstCellNum(); index2 < row.getLastCellNum(); index2++) {
                Cell cell = row.getCell(index2);
                if (index2 == 0) {
                    car.setId((long) cell.getNumericCellValue());
                } else if (index2 == 1) {
                    car.setName(cell.getStringCellValue());
                } else if (index2 == 2) {
                    car.setBrand(cell.getStringCellValue());
                } else if (index2 == 3) {
                    car.setModelNo((long) cell.getNumericCellValue());
                } else if (index2 == 4) {
                    car.setInventoryId((long) cell.getNumericCellValue());
                } else {
                    log.error("Car data not found ");
                }
            }
            carList.add(car);
        }
    }
}
