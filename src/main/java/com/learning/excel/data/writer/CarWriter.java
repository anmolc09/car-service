package com.learning.excel.data.writer;

import com.learning.entities.Car;
import com.learning.excel.data.reader.CarReader;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class CarWriter {

    public void createCarSheet(Workbook workbook, List<Car> carList) throws IOException {
        String[] headers = {"Id", "Name", "Brand", "Model No.", "Inventory Id"};

        // create a Sheet
        Sheet sheet = workbook.createSheet("Car");

        // method call for headerCell styling
        CellStyle headerCellStyle = getHeaderCellStyle(workbook);

        // method call for header row creation
        createHeaderRow(headers, sheet, headerCellStyle);

        // method call for data rows creation
        createDataRows(carList, workbook, sheet);

        // Resize all columns to fit the content size
        for(int index = 0; index < headers.length; index++) {
            sheet.autoSizeColumn(index);
        }

        FileOutputStream fileOutputStream = new FileOutputStream(".\\resources\\poi-data.xlsx");
        workbook.write(fileOutputStream);

        fileOutputStream.close();

    }

    private static void createDataRows(List<Car> carList, Workbook workbook, Sheet sheet) {
        CellStyle dataCellStyle = workbook.createCellStyle();
        dataCellStyle.setAlignment(HorizontalAlignment.CENTER);
        dataCellStyle.setFillForegroundColor((short) 22);
        dataCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        dataCellStyle.setBorderBottom(BorderStyle.THIN);
        dataCellStyle.setBorderTop(BorderStyle.THIN);
        dataCellStyle.setBorderLeft(BorderStyle.THIN);
        dataCellStyle.setBorderRight(BorderStyle.THIN);

        for(int rowNum = 0; rowNum < carList.size(); rowNum++) {
            Row row = sheet.createRow(rowNum + 1);

            Cell zeroCell = row.createCell(0);
            zeroCell.setCellValue(carList.get(rowNum).getId());
            zeroCell.setCellStyle(dataCellStyle);

            Cell firstCell = row.createCell(1);
            firstCell.setCellValue(carList.get(rowNum).getName());
            firstCell.setCellStyle(dataCellStyle);

            Cell secondCell = row.createCell(2);
            secondCell.setCellValue(carList.get(rowNum).getBrand());
            secondCell.setCellStyle(dataCellStyle);

            Cell thirdCell = row.createCell(3);
            thirdCell.setCellValue(carList.get(rowNum).getModelNo());
            thirdCell.setCellStyle(dataCellStyle);

            Cell fourthCell = row.createCell(4);
            fourthCell.setCellValue(carList.get(rowNum).getInventoryId());
            fourthCell.setCellStyle(dataCellStyle);
        }
    }

    private static void createHeaderRow(String[] headers, Sheet sheet, CellStyle headerCellStyle) {

        Row headerRow = sheet.createRow(0);

        for(int index = 0; index < headers.length; index++) {
            Cell headerCell = headerRow.createCell(index);
            headerCell.setCellValue(headers[index]);
            headerCell.setCellStyle(headerCellStyle);
        }
    }

    private static CellStyle getHeaderCellStyle(Workbook workbook) {

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setColor(IndexedColors.LIGHT_BLUE.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
        headerCellStyle.setFont(headerFont);
        headerCellStyle.setFillForegroundColor((short) 13);
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerCellStyle.setBorderBottom(BorderStyle.THIN);
        headerCellStyle.setBorderTop(BorderStyle.THIN);
        headerCellStyle.setBorderLeft(BorderStyle.THIN);
        headerCellStyle.setBorderRight(BorderStyle.THIN);

        return headerCellStyle;
    }
}
