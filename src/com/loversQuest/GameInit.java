package com.loversQuest;

import com.loversQuest.excelReader.ReadExcel;
import com.loversQuest.gameWorldPieces.*;
import java.util.Map;

public class GameInit {
    public static Map<String, Location> locationMap = ReadExcel.getLocationMap();
    public Player p1 = new Player("Bob", locationMap.get("gazebo"));

    public void addRing(){
        p1.addItem(new Item("Diamond Ring", "test ring"));
    }

    public boolean isGameOver(){
        boolean gameOver = false;
        if(this.p1.isHasKiss()){
            gameOver = true;
        }
        return gameOver;
    }
}
