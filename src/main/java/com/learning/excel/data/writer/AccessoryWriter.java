package com.learning.excel.data.writer;

import com.learning.excel.data.reader.AccessoryReader;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class AccessoryWriter {

    @Autowired
    private AccessoryReader accessoryReader;

    public void createAccessorySheet(Workbook workbook) throws IOException {

        String[] headers = {"Id", "Name", "Price", "Car id"};

        List<Accessory> accessoryList = null;

        try{
            accessoryList = accessoryReader.getAccessoryObjects();
        }catch(Exception e){
            log.error(e.getMessage(), e);
        }


        CreationHelper creationHelper = workbook.getCreationHelper();

        Sheet sheet = workbook.createSheet("Accessory");

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

        for(int rowNum = 0; rowNum < accessoryList.size(); rowNum++) {

            Row row = sheet.createRow(rowNum + 1);

            Cell zeroCell = row.createCell(0);
            zeroCell.setCellValue(accessoryList.get(rowNum).getId());
            zeroCell.setCellStyle(dataCellStyle);

            Cell firstCell = row.createCell(1);
            firstCell.setCellValue(accessoryList.get(rowNum).getName());
            firstCell.setCellStyle(dataCellStyle);

            Cell secondCell = row.createCell(2);
            secondCell.setCellValue(accessoryList.get(rowNum).getPrice());
            secondCell.setCellStyle(dataCellStyle);

            Cell thirdCell = row.createCell(3);
            thirdCell.setCellValue(accessoryList.get(rowNum).getCarId());
            thirdCell.setCellStyle(dataCellStyle);

        }

        // Resize all columns to fit the content size
        for(int index = 0; index < headers.length; index++) {
            sheet.autoSizeColumn(index);
        }


        FileOutputStream fileOut = new FileOutputStream(".\\resources\\copy-data.xlsx");
        workbook.write(fileOut);
        fileOut.close();


    }



}
