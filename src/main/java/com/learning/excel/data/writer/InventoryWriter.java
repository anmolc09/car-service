package com.learning.excel.data.writer;

import com.learning.entities.Inventory;
import com.learning.enums.InventoryType;
import com.learning.excel.data.reader.InventoryReader;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class InventoryWriter {

    @Autowired
    private InventoryReader inventoryReader;

    public void createInventorySheet(Workbook workbook) throws IOException {

        String[] headers = {"Id", "Location", "Type"};

        List<Inventory> inventoryList = null;

        try{
            inventoryList = inventoryReader.getInventoryObjects();
        }catch(Exception e){
            log.error(e.getMessage(), e);
        }


        CreationHelper creationHelper = workbook.getCreationHelper();

        Sheet sheet = workbook.createSheet("Inventory");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short)14);
        headerFont.setColor(IndexedColors.BLUE.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
        headerCellStyle.setFillForegroundColor((short) 13);
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerCellStyle.setBorderTop(BorderStyle.THIN);
        headerCellStyle.setBorderBottom(BorderStyle.THIN);
        headerCellStyle.setBorderLeft(BorderStyle.THIN);
        headerCellStyle.setBorderRight(BorderStyle.THIN);

        Row headerRow = sheet.createRow(0);

        for (int i=0; i < headers.length; i++){
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerCellStyle);
        }

        CellStyle dataCellStyle = workbook.createCellStyle();
        dataCellStyle.setAlignment(HorizontalAlignment.CENTER);
        dataCellStyle.setBorderTop(BorderStyle.THIN);
        dataCellStyle.setBorderBottom(BorderStyle.THIN);
        dataCellStyle.setBorderLeft(BorderStyle.THIN);
        dataCellStyle.setBorderRight(BorderStyle.THIN);

        for(int rowNum = 0; rowNum < inventoryList.size(); rowNum++) {

            Row row = sheet.createRow(rowNum + 1);

            Cell zeroCell = row.createCell(0);
            zeroCell.setCellValue(inventoryList.get(rowNum).getId());
            zeroCell.setCellStyle(dataCellStyle);

            Cell firstCell = row.createCell(1);
            firstCell.setCellValue(inventoryList.get(rowNum).getLocation());
            firstCell.setCellStyle(dataCellStyle);

            Cell secondCell = row.createCell(2);
            if(inventoryList.get(rowNum).getType().equals(InventoryType.EXTERNAL)) {
                secondCell.setCellValue("EXTERNAL");
            } else if(inventoryList.get(rowNum).getType().equals(InventoryType.INTERNAL)) {
                secondCell.setCellValue("INTERNAL");
            } else {
                secondCell.setCellValue("");
            }
            secondCell.setCellStyle(dataCellStyle);
        }

     /*   int rowNum = 1;

        for (Inventory inventory : inventoryList) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0)
                    .setCellValue(inventory.getId());

            row.createCell(1)
                    .setCellValue(inventory.getLocation());

            if (inventory.getType().("Internal"))
            row.createCell(2)
                    .setCellValue(inventory.getType());

        }*/

        // Resize all columns to fit the content size
        for(int index = 0; index < headers.length; index++) {
            sheet.autoSizeColumn(index);
        }


        FileOutputStream fileOut = new FileOutputStream(".\\resources\\copy-data.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();

    }

}
