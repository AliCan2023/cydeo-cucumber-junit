package com.cydeo.ApachieTests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {

    @Test

    public void read_from_excelFile() throws IOException {

        String path = "SampleData.xlsx";

        File file = new File(path);

        // to read from excel we need to load it to FileInput Stream;
        FileInputStream fileInputStream = new FileInputStream(file);

        // workbook>sheet>row>cell
        //<1> Create a workbook
        //XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //<2> We need to get specific sheet from currently opened workbook

        XSSFSheet sheet = workbook.getSheet("Employees");

        //<3>Select row and cell;
        //print out Ali's cell
        // In our Excel data indexes start from 0;
        System.out.println(sheet.getRow(1).getCell(0));

        //print out Developer
        System.out.println(sheet.getRow(4).getCell(2));

        //Return the count of used cells only and starts from 1
        int usedRows = sheet.getPhysicalNumberOfRows();
        System.out.println(usedRows);

        //Returns the number from top cell to bottom cell;
        // it doesn't care if the cell is empty or not
        //Starts counting from 0;

        int lastUsedRow = sheet.getLastRowNum();
        System.out.println(lastUsedRow);

        //Let's find the specific name or cell dynamically;
        //TODO: Create a logic to print Mustafa's name;

        for (int rowNum = 0; rowNum<usedRows; rowNum++){

            if (sheet.getRow(rowNum).getCell(0).toString().equals("Mustafa")){
                System.out.println(sheet.getRow(rowNum).getCell(0));
            }
        }

        //TODO: Create a logic to print out Irfan's JobTitle;
        // Check if name is Irfan ----> print out JobTitle

        for (int rowNum = 0; rowNum<usedRows;rowNum++){
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Mustafa")){
                System.out.println("Mustafa's Job title is "+ sheet.getRow(rowNum).getCell(2));
            }
        }





    }
}
