package com.learning.excel.data.reader;

import com.learning.entities.Accessory;
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
public class AccessoryReader {

    public List<Accessory> getAccessoryObjects() throws IOException {
        FileInputStream file = new FileInputStream(new File(".\\resources\\data.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        XSSFSheet sheet = workbook.getSheetAt(2);

        List<Accessory> accessoryList = new ArrayList<>();

        getAccessoryList(sheet, accessoryList);
        file.close();
        return accessoryList;
    }

    private static void getAccessoryList(XSSFSheet sheet, List<Accessory> accessoryList) {
        for (int index = sheet.getFirstRowNum() + 1; index <= sheet.getLastRowNum(); index++) {
            Row row = sheet.getRow(index);
            Accessory accessory = Accessory.builder().build();

            for (int index2 = row.getFirstCellNum(); index2 < row.getLastCellNum(); index2++) {
                Cell cell = row.getCell(index2);
                if (index2 == 0) {
                    accessory.setId((long) cell.getNumericCellValue());
                } else if (index2 == 1) {
                    accessory.setName(cell.getStringCellValue());
                } else if (index2 == 2) {
                    accessory.setPrice(cell.getNumericCellValue());
                } else if (index2 == 3) {
                    accessory.setCarId((long) cell.getNumericCellValue());
                } else {
                    log.error("Accessory data not found ");
                }
            }
            accessoryList.add(accessory);
        }
    }
}
