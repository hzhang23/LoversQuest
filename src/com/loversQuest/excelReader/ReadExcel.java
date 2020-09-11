package com.loversQuest.excelReader;

import com.loversQuest.gameWorldPieces.Location;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.*;

public class ReadExcel {

    String Book1 = "resources/Book1.xlsx";

    private List<Location> readFromXL(String filePath) {
        File excelFile = null;
        InputStream xlObj = null;
        String cellStr = null;
        List<Location> locationList = new ArrayList<>();
        Location location = null;
        excelFile = new File(filePath);
        try {
            xlObj = new FileInputStream(excelFile);
            Workbook locationBook = WorkbookFactory.create(xlObj);
            Sheet locationSheet = locationBook.getSheet("location");
            for(int i = 1; i <= locationSheet.getLastRowNum(); i++){
                location = new Location();
                Row row = locationSheet.getRow(i);
                if (row == null){
                    continue;
                }
                for(int j = 0; j< row.getLastCellNum(); j++){
                    Cell cell = row.getCell(j);
                    cellStr = cell.getStringCellValue();
                    switch (j){
                        case 0:{
                            location.setName(cellStr);
                        }
                        case 1:{
                            location.setDescription(cellStr);
                        }
                        locationList.add(location);
                        break;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return locationList;
    }

    public static void main(String[] args) {
        ReadExcel reader = new ReadExcel();
        ArrayList<Location> locations = (ArrayList<Location>) reader.readFromXL("resources/Book1.xlsx");
        Location Barracks = locations.get(1);
        System.out.println(Barracks.getDescription());
    }

}
