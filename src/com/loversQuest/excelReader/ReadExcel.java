package com.loversQuest.excelReader;

import com.loversQuest.gameWorldPieces.Location;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.loversQuest.gameWorldPieces.NonPlayerCharacters;
import com.loversQuest.gameWorldPieces.models_NPC.NPC_Properties;
import org.apache.poi.ss.usermodel.*;

public class ReadExcel {
    private String gameBookPath = "resources/gameBook.xlsx";

    private ReadExcel(){
        //private for static class
    }

    private static Workbook getGamebook(String filePath){
       Workbook gameBook = null;
        try {
            File excelFile = new File(filePath);
            InputStream excelObject = new FileInputStream(excelFile);
            gameBook = WorkbookFactory.create(excelObject);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gameBook;
    }

    public static List<Location> getLocationList(String filePath) {
            Workbook locationBook = getGamebook(filePath);
            Sheet locationSheet = locationBook.getSheet("location");
            String cellStr = null;
            List<Location> locationList = new ArrayList<>();
            for(int rowNum = 1; rowNum <= locationSheet.getLastRowNum(); rowNum++){
                Location location = new Location();
                Row row = locationSheet.getRow(rowNum);
                for(int cellNum = 0; cellNum< row.getLastCellNum(); cellNum++){
                    Cell cell = row.getCell(cellNum);
                    cellStr = cell.getStringCellValue().toLowerCase();
                    switch (cellNum){
                        case 0:{
                            location.setName(cellStr);
                            break;
                        }
                        case 1: {
                            location.setDescription(cellStr);
                            break;
                        }
                    }
                }
                locationList.add(location);
            }
        return locationList;
    }

    public static List<NonPlayerCharacters> getNpcList(String filePath, List<Location> locationList){
        Workbook locationBook = getGamebook(filePath);
        Sheet npcSheet = locationBook.getSheet("npc");
        List<NonPlayerCharacters> npcList = new ArrayList<>();
        String cellString = null;
        for (int rowNum = 1; rowNum <= npcSheet.getLastRowNum(); rowNum++){
            Row row = npcSheet.getRow(rowNum);
            NonPlayerCharacters npc = new NonPlayerCharacters();
            for(int cellNum =0; cellNum <=row.getLastCellNum();cellNum++){
                Cell cell = row.getCell(cellNum);
                cellString = cell.getStringCellValue().toUpperCase();
                switch (cellNum){
                    case(0)-> {
                        for (NPC_Properties property : NPC_Properties.values()){
                            if(property.toString().equals(cellString));
                            npc.setProperties(property);
                            break;
                        }
                    }
                    case(1)->{
                        npc.setName(cellString);
                        break;
                    }
                    case(2)->{
                        npc.setDescription(cellString);
                        break;
                    }
                    case(3)->{
                        for(Location location : locationList){
                            if (location.getName().toUpperCase().equals(cellString)){
                                npc.setLocation(location);
                                break;
                            }
                        }
                    }
                }
            }
            npcList.add(npc);
        }
        return npcList;
    }



    public static void main(String[] args) {
        ReadExcel reader = new ReadExcel();
        ArrayList<Location> locations = (ArrayList<Location>) reader.getLocationList("resources/gameBook.xlsx");
        Location Barracks = locations.get(2);
        System.out.println(Barracks.getDescription());

    }

}
