package com.loversQuest.gameWorldPieces.models_NPC;

import com.loversQuest.GUI.GameFrame;
import com.loversQuest.clsMinigame.CLSGame;
//import com.loversQuest.clsMinigame.CombatLifeSaverMinigame;
import com.loversQuest.excelReader.JsonGetter;
import com.loversQuest.gameWorldPieces.Item;
import com.loversQuest.gameWorldPieces.Location;
import com.loversQuest.gameWorldPieces.NonPlayerCharacters;
import com.loversQuest.gameWorldPieces.Player;

import java.util.List;
import java.util.Scanner;

public class DrillSGT_CLS extends NonPlayerCharacters {

    public DrillSGT_CLS(String name, String description, Location location, NPC_Properties properties){
        super(name, description,location, properties);
    }

    @Override
    public String interact(Player player) {
        String returnMsg = null;
        if(player.isHasCertainItem("combat life saver badge")){
            returnMsg = JsonGetter.getStarWarAPI();
        }else {
            returnMsg = "miniGameInit";
        }
        return returnMsg;
    }
}
