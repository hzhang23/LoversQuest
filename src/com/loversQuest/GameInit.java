package com.loversQuest;

import com.loversQuest.excelReader.ReadExcel;
import com.loversQuest.gameWorldPieces.*;

import java.util.List;
import java.util.Map;

public class GameInit {
    public static String filePath = "resources/gameBook.xlsx";
    public static List<Location> locationList = ReadExcel.getLocationList(filePath);
    public static List<NonPlayerCharacters> npcList = ReadExcel.getNpcList(filePath);
    public static Map<String, Location> locationMap = ReadExcel.getLocationMap(filePath);
    public static List<Item> itemList = ReadExcel.getItemList(filePath);
    public static List<Container> containersList = ReadExcel.getContainerList(filePath);

    static List<NonPlayerCharacters> npcForGame = NPC_Factory.getNPCs(npcList);

    public Player p1 = new Player("Bob", locationList.get(1));


    public boolean isGameOver(){
        boolean gameOver = false;
        if(this.p1.isHasKiss()){
            gameOver = true;
        }
        return gameOver;
    }


    public static void main(String[] args) {
        Player p1 = new Player("Bob", locationMap.get("barracks"));
        System.out.println(npcForGame);
    }





}
