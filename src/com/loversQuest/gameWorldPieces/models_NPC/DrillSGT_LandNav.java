package com.loversQuest.gameWorldPieces.models_NPC;

import com.loversQuest.gameWorldPieces.NonPlayerCharacters;
import com.loversQuest.gameWorldPieces.Player;

public class DrillSGT_LandNav extends NonPlayerCharacters {

    public DrillSGT_LandNav(String name, String description) {
        super(name, description);
    }

    @Override
    public String interact(Player player) {
        String returnMsg = "if you don't want to be lost as LT, come talk me";
        /**
         * TODO: write DrillLandNav interact, need player to explore all room to get land_nav badge
         */
        return returnMsg;
    }



}
