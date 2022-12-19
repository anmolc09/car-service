package com.learning.excel.data.reader;

import com.learning.entities.Inventory;
import com.learning.enums.InventoryType;
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

@Slf4j
@Component
public class InventoryReader {

    public List<Inventory> getInventoryObjects() throws IOException {
        FileInputStream file = new FileInputStream(new File(".\\resources\\data.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);

        List<Inventory> inventoryList = new ArrayList<>();

        getInventoryList(sheet, inventoryList);

        file.close();
        return inventoryList;
    }

    private static void getInventoryList(XSSFSheet sheet, List<Inventory> inventoryList) {

        for (int index = sheet.getFirstRowNum() + 1; index <= sheet.getLastRowNum(); index++) {
            Row row = sheet.getRow(index);
            Inventory inventory = Inventory.builder().build();

            for (int index2 = row.getFirstCellNum(); index2 < row.getLastCellNum(); index2++) {
                Cell cell = row.getCell(index2);
                if (index2 == 0) {
                    inventory.setId((long) cell.getNumericCellValue());
                } else if (index2 == 1) {
                    inventory.setLocation(cell.getStringCellValue());
                } else if (index2 == 2) {
                    if (cell.getStringCellValue().equalsIgnoreCase("EXTERNAL")) {
                        inventory.setType(InventoryType.EXTERNAL);
                    } else if (cell.getStringCellValue().equalsIgnoreCase("INTERNAL")) {
                        inventory.setType(InventoryType.INTERNAL);
                    } else {
                        inventory.setType(null);
                    }
                } else {
                    log.error("Data not found " + row.getLastCellNum());
                }
            }
            inventoryList.add(inventory);
        }
    }
}

