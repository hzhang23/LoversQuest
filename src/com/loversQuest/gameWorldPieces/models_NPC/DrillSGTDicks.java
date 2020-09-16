package com.loversQuest.gameWorldPieces.models_NPC;
import com.loversQuest.gameWorldPieces.NonPlayerCharacters;
import com.loversQuest.gameWorldPieces.Player;

public class DrillSGTDicks extends NonPlayerCharacters {

    public DrillSGTDicks(String name, String description) {
        super(name, description);
    }

    @Override
    public String interact(Player player) {
        String returnMsg = "Private, I have more details for you";
        /**
         * TODO: write DrillSGT Dicks interact method, do details and change player location
         */
        return returnMsg;
    }
}
