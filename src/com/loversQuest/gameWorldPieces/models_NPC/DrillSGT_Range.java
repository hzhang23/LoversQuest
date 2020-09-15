package com.loversQuest.gameWorldPieces.models_NPC;

import com.loversQuest.gameWorldPieces.NonPlayerCharacters;
import com.loversQuest.gameWorldPieces.Player;

public class DrillSGT_Range extends NonPlayerCharacters {

    public DrillSGT_Range(String name, String description) {
        super(name, description);
    }

    @Override
    public String interact(Player player) {
        String returnMsg = "get contact? shoot back! (with Knife hand)";
        /**
         * TODO: write DrillHwak_eyes interact, meet player at range and shoot
         */
        return returnMsg;
    }

}
