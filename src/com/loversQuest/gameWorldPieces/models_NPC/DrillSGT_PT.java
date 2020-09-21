package com.loversQuest.gameWorldPieces.models_NPC;

import com.loversQuest.excelReader.JsonGetter;
import com.loversQuest.gameWorldPieces.Location;
import com.loversQuest.gameWorldPieces.NonPlayerCharacters;
import com.loversQuest.gameWorldPieces.Player;

public class DrillSGT_PT extends NonPlayerCharacters {
    public DrillSGT_PT(String name, String description, Location location, NPC_Properties properties){
        super(name, description,location, properties);
    }

    @Override
    public String interact(Player player) {
        String returnMsg = "do Push ups";
        if(player.isHasCertainItem("Physical Training Badge")){
            returnMsg = JsonGetter.kanyeQuotes();
        }else {
            returnMsg = "miniGameInit";
        }
        return returnMsg;
    }



}
