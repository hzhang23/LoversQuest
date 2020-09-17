package com.loversQuest.excelReader;

import com.loversQuest.gameWorldPieces.*;

import java.io.*;
import java.util.*;

import com.loversQuest.gameWorldPieces.models_NPC.NPC_Properties;
import org.apache.poi.ss.usermodel.*;

public class ReadExcel {
    private final static String gameBookPath = "resources/gameBook.xlsx";

    private ReadExcel(){
        //private for static class
    }

    /**
     * getter/setter for gameMap obj and gameObjList
      * @return map
     */

    public static Map<String, Location> getLocationMap(){
        return createLocationMap(gameBookPath);
    }
    public static Map<String, List<String>> getGameObjList() {return createGameObjMap(gameBookPath);}



    /**
     * get Excel data and create a Workbook Object
     * @param filePath take filepath of xls
     * @return Workbook obj
     */
    private static Workbook getGamebook(String filePath){
       Workbook gameBook = null;
        try {
            File excelFile = new File(filePath);
            InputStream excelObject = new FileInputStream(excelFile);
            gameBook = WorkbookFactory.create(excelObject);

        } catch (IOException e) {
            e.printStackTrace();
            //TODO: add a pop up alert to set up excel sheet
        }
        return gameBook;
    }

    /**
     * get npcList from npc sheet
     * @param filePath path of xls file
     * @return npcList
     */

    public static List<NonPlayerCharacters> getNpcList (String filePath){
        Workbook gameBook = getGamebook(filePath);
        List<Location> locationList = getLocationList(filePath);
        Sheet npcSheet = gameBook.getSheet("npc");
        List<NonPlayerCharacters> npcList = new ArrayList<>();
        String cellString;
        for (int i = 1; i < npcSheet.getLastRowNum(); i++) {
            Row row = npcSheet.getRow(i);
            NonPlayerCharacters npc = new NonPlayerCharacters();
            for (int j = 0; j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                cellString = cell.getStringCellValue();
                switch(j){
                    case 0 ->{
                        npc.setName(cellString);
                        break;
                    }
                    case 1 ->{
                        npc.setDescription(cellString);
                        break;
                    }
                    case 2 ->{
                        for (Location location : locationList){
                            String locationName = location.getName();
                            if(cellString.toUpperCase().equals(locationName.toUpperCase())){
                                npc.setLocation(location);
                            }
                        }
                        break;
                    }
                    case 3 ->{
                        for (NPC_Properties property : NPC_Properties.values()){
                            String npcProperty = property.name();
                            if (cellString.toUpperCase().equals(npcProperty)){
                                npc.setProperties(property);
                            }
                        }
                        break;
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + j);
                }
            }
            npcList.add(npc);
        }
        return NPC_Factory.getNPCs(npcList);
    }
    /**
     * get item list from excel sheet
     * @param filePath path of xls
     * @return itemList
     */
    public static List<Item> getItemList(String filePath){
        List<Item> itemList = new ArrayList<>();
        Workbook gameBook = getGamebook(filePath);
        Sheet itemSheet = gameBook.getSheet("item");
        String cellStr;
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
    /**
     * get containerList from container sheet
     * @param filePath same as above
     * @return containerList
     */
    public static List<Container> getContainerList(String filePath){
        Workbook gameBook = getGamebook(filePath);
        List<Item> itemList = getItemList(filePath);
        Sheet containerSheet = gameBook.getSheet("container");
        String cellStr = null;
        List<Container> containerList = new ArrayList<>();
        for(int rowNum = 1; rowNum <= containerSheet.getLastRowNum(); rowNum++){
            Container container = new Container();
            Row row = containerSheet.getRow(rowNum);
            for(int cellNum = 0; cellNum <= row.getLastCellNum(); cellNum++){
                Cell cell = row.getCell(cellNum);
                if (cell == null){
                    continue;
                }
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
                    case 2 -> {
                        List<String> itemName = Arrays.asList(cellStr.split(","));
                        for (Item item : itemList){
                            if(itemName.contains(item.getName())){
                                container.addItem(item);
                            }
                        }
                        break;
                    }
                    case 3 ->{
                            container.setLocation(cellStr);
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
     * return a locationMap with each location contain occupants & container
     * @param filePath
     * @return
     */
    public static Map<String, Location> createLocationMap(String filePath){
        Map<String, Location> locationMap = new HashMap<>();
        Workbook gameBook = getGamebook(filePath);
        List<Location> locationList = getLocationList(filePath);
        List<NonPlayerCharacters> npcList = getNpcList(filePath);
        List<Container> containerList = getContainerList(filePath);
        for (Location location : locationList){
            for(NonPlayerCharacters npc : npcList) {
                String npcLocation = npc.getLocation();
                if (location.getName().equals(npcLocation)) {
                    location.addOccupants(npc);
                }
            }
            for(Container container : containerList){
                String conLocation = container.getLocation();
                if(location.getName().equals(conLocation)){
                    location.setContainer(container);
                }
            }
            locationMap.put(location.getName(), location);
        }
        return locationMap;
    }

    /**
     * create a Map<String, List<String>> to filter through the objResponse
     */

    private static Map<String, List<String>> createGameObjMap(String filePath){
        Map<String, List<String>> gameObjMap = new HashMap<>();
        Workbook gameBook = getGamebook(filePath);
        Sheet objSheet = gameBook.getSheet("objInGame");
        String cellstr;
        //first to take all the key value and generate basic map structure
        Row keyRow = objSheet.getRow(0);
        for(int i = 0; i< keyRow.getLastCellNum(); i++){
            List<String> objList = new ArrayList<>();
            Cell cell = keyRow.getCell(i);
            cellstr = cell.getStringCellValue().toLowerCase().trim();
            gameObjMap.put(cellstr, objList);
        }
        //second to add value to each list
        for (int rowNum = 1; rowNum<= objSheet.getLastRowNum(); rowNum++){
            Row row = objSheet.getRow(rowNum);
            int cellNum = 0;
            while (cellNum < row.getLastCellNum()){
                int i = row.getLastCellNum();
                String key = keyRow.getCell(cellNum).getStringCellValue().toLowerCase().trim();
                Cell cell = row.getCell(cellNum);
                if (cell != null){
                    cellstr = cell.getStringCellValue().toLowerCase();
                    gameObjMap.get(key).add(cellstr);
                }
                cellNum++;
            }
        }
        return gameObjMap;
    }
}
