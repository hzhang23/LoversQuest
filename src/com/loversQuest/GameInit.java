package com.loversQuest;

import com.loversQuest.excelReader.ReadExcel;
import com.loversQuest.gameWorldPieces.*;
import java.util.Map;

public class GameInit {
    public static Map<String, Location> locationMap = ReadExcel.getLocationMap();
    public Player p1 = new Player("Bob", locationMap.get("barracks"));


    public boolean isGameOver(){
        boolean gameOver = false;
        if(this.p1.isHasKiss()){
            gameOver = true;
        }
        return gameOver;
    }
}
