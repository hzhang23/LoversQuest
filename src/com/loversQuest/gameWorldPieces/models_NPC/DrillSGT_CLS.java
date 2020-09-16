package com.loversQuest.gameWorldPieces.models_NPC;

import com.loversQuest.gameWorldPieces.Item;
import com.loversQuest.gameWorldPieces.Location;
import com.loversQuest.gameWorldPieces.NonPlayerCharacters;
import com.loversQuest.gameWorldPieces.Player;

import java.util.List;

public class DrillSGT_CLS extends NonPlayerCharacters {

    private String clsBadge = "combat life saver badge";

    public DrillSGT_CLS(String name, String description, Location location, NPC_Properties properties){
        super(name, description,location, properties);
    }

    @Override
    public String interact(Player player) {
        String returnMsg = null;
        if(player.isHasCertainItem(clsBadge)){
            returnMsg = "good work, Private! what a shiny badge!";
        }else {
            returnMsg = "Private! time to check your CLS knowledge, don't tell me that you still use duct tape for everything!";
        }
        return returnMsg;
    }



}
