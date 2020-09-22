package com.loversQuest;

import com.loversQuest.excelReader.ExcelManager;
import com.loversQuest.excelReader.JsonGetter;
import com.loversQuest.gameWorldPieces.*;
import java.util.Map;

public class GameInit {
    public static Map<String, Location> locationMap = ExcelManager.getLocationMap();
    public Player player;

    public Player readGameFile(String gamefile){
        player = JsonGetter.readGame(gamefile);
        return player;
    }


}
