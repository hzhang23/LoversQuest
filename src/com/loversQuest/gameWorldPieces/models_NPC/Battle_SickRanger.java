package com.loversQuest.gameWorldPieces.models_NPC;

import com.loversQuest.gameWorldPieces.Location;
import com.loversQuest.gameWorldPieces.NonPlayerCharacters;
import com.loversQuest.gameWorldPieces.Player;

public class Battle_SickRanger extends NonPlayerCharacters {
    public Battle_SickRanger(String name, String description, Location location, NPC_Properties properties){
        super(name, description,location, properties);
    }

    @Override
    public String interact(Player player){
        String returnMsg = null;
        /**
         * your code in here
         */
        return returnMsg;
    }

}
