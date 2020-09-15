package com.loversQuest.excelReader;

import com.loversQuest.gameWorldPieces.Container;
import com.loversQuest.gameWorldPieces.Item;
import com.loversQuest.gameWorldPieces.Location;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.loversQuest.gameWorldPieces.NonPlayerCharacters;
import com.loversQuest.gameWorldPieces.models_NPC.NPC_Properties;
import org.apache.poi.ss.usermodel.*;

import javax.swing.*;

public class ReadExcel {
    private String gameBookPath = "resources/gameBook.xlsx";

    private ReadExcel(){
        //private for static class
    }

    /**
     * get Excel data and create a Workbook Object
     * @param filePath
     * @return
     */
    private static Workbook getGamebook(String filePath){
       Workbook gameBook = null;
        try {
            File excelFile = new File(filePath);
            InputStream excelObject = new FileInputStream(excelFile);
            gameBook = WorkbookFactory.create(excelObject);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            //TODO: add a pop up alert to set up excel sheet
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gameBook;
    }

    /**
     * get item list from excel sheet
     * @param filePath
     * @return
     */
    public static List<Item> getItemList(String filePath){
        List<Item> itemList = new ArrayList<>();
        Workbook gameBook = getGamebook(filePath);
        Sheet itemSheet = gameBook.getSheet("item");
        String cellStr = null;
        for (int rowNum = 1; rowNum <= itemSheet.getLastRowNum();rowNum++){
            Item item = new Item();
            Row row = itemSheet.getRow(rowNum);
            for (int cellNum =0; cellNum < row.getLastCellNum(); cellNum++){
                Cell cell = row.getCell(cellNum);
                cellStr = cell.getStringCellValue().toLowerCase();
                switch (cellNum){
                    case 0 ->{
                        item.setName(cellStr);
                        break;
                    }
                    case 1 ->{
                        item.setUseResponse(cellStr);
                        break;
                    }
                }
            }
            itemList.add(item);
        }
        return itemList;
    }
    /** TODO: add container items
     * get containerList from container sheet
     * @param filePath
     * @return
     */
    public static List<Container> getContainerList(String filePath){
        Workbook gameBook = getGamebook(filePath);
        Sheet containerSheet = gameBook.getSheet("container");
        String cellStr = null;
        List<Container> containerList = new ArrayList<>();
        for(int rowNum = 1; rowNum <= containerSheet.getLastRowNum(); rowNum++){
            Container container = new Container();
            Row row = containerSheet.getRow(rowNum);
            for(int cellNum = 0; cellNum < row.getLastCellNum(); cellNum++){
                Cell cell = row.getCell(cellNum);
                cellStr = cell.getStringCellValue().toLowerCase();
                switch (cellNum){
                    case 0 -> {
                        container.setName(cellStr);
                        break;
                    }
                    case 1 -> {
                        container.setUseResponse(cellStr);
                        break;
                    }
                }
            }
            containerList.add(container);
        }
        return containerList;
    }

    /**
     * get location list sheet from Location sheet
     * @param filePath
     * @return
     */
    public static List<Location> getLocationList(String filePath) {
        Workbook gameBook = getGamebook(filePath);
        Sheet locationSheet = gameBook.getSheet("location");
        String cellStr = null;
        List<Location> locationList = new ArrayList<>();
        for (int rowNum = 1; rowNum <= locationSheet.getLastRowNum(); rowNum++) {
            Location location = new Location();
            Row row = locationSheet.getRow(rowNum);
            for (int cellNum = 0; cellNum < row.getLastCellNum(); cellNum++) {
                Cell cell = row.getCell(cellNum);
                cellStr = cell.getStringCellValue().toLowerCase().trim();
                switch (cellNum) {
                    case 0: {
                        location.setName(cellStr);
                        break;
                    }
                    case 5: {
                        location.setDescription(cellStr);
                        break;
                    }
                }
            }
            locationList.add(location);
        }
        for (int rowNum = 1; rowNum <= locationSheet.getLastRowNum(); rowNum++) {
            Row row = locationSheet.getRow(rowNum);
            for (int cellNum = 0; cellNum < row.getLastCellNum(); cellNum++) {
                Cell cell = row.getCell(cellNum);
                String locationName = row.getCell(0).getStringCellValue().toLowerCase();
                if (cell.getStringCellValue() != ""){
                    cellStr = cell.getStringCellValue().toLowerCase().trim();
                } else {
                    cellStr = "nothing";
                }
                for (Location location : locationList){
                    if (location.getName().equals(locationName)){
                        switch (cellNum) {
                            case 1 -> {
                                location.setEast(cellStr);
                                break;
                            }
                            case 2 -> {
                                location.setWest(cellStr);
                                break;
                            }
                            case 3 -> {
                                location.setNorth(cellStr);
                                break;
                            }
                            case 4 -> {
                                location.setSouth(cellStr);
                                break;
                            }
                                }
                            }
                        }
                    }
                }
            return locationList;
        }

        /**
         * get npcList from npc sheet
         * @param filePath
         * @param locationList
         * @return
         */

        public static List<NonPlayerCharacters> getNpcList (String filePath, List < Location > locationList){
            Workbook gameBook = getGamebook(filePath);
            Sheet npcSheet = gameBook.getSheet("npc");
            List<NonPlayerCharacters> npcList = new ArrayList<>();
            String cellString = null;
            for (int rowNum = 1; rowNum <= npcSheet.getLastRowNum(); rowNum++) {
                Row row = npcSheet.getRow(rowNum);
                NonPlayerCharacters npc = new NonPlayerCharacters();
                for (int cellNum = 0; cellNum <= row.getLastCellNum(); cellNum++) {
                    Cell cell = row.getCell(cellNum);
                    cellString = cell.getStringCellValue().toUpperCase();

                }
            }
            return npcList;
        }



    public static void main(String[] args) {
        ReadExcel reader = new ReadExcel();
        String path = "resources/gameBook.xlsx";
        List<Container> containerList = getContainerList("resources/gameBook.xlsx");
        List<Item> itemList = getItemList(path);
        System.out.println(containerList.get(1).getName());
        System.out.println(itemList.get(1).getName());
        ArrayList<Location> locations = (ArrayList<Location>) reader.getLocationList("resources/gameBook.xlsx");
        List<NonPlayerCharacters> npcList = reader.getNpcList("resources/gameBook.xlsx", locations);
        System.out.println(npcList.get(0).getName());

    }

}
