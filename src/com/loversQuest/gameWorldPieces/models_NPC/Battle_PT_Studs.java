package com.loversQuest.gameWorldPieces.models_NPC;

import com.loversQuest.gameWorldPieces.NonPlayerCharacters;
import com.loversQuest.gameWorldPieces.Player;

public class Battle_PT_Studs extends NonPlayerCharacters {

    public Battle_PT_Studs(String name, String description){
        super(name,description);
    }

    @Override
    public String interact(Player player){
        String returnMsg = null;

        /**
         * PT studs interact, if meet in GYM, improve PT, need to give him peanut butter or Protein powder to maintain relationship
         */

        return  returnMsg;
    }

}
