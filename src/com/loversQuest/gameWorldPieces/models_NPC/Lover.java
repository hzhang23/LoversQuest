package com.loversQuest.gameWorldPieces.models_NPC;

import com.loversQuest.gameWorldPieces.NonPlayerCharacters;
import com.loversQuest.gameWorldPieces.Player;

public class Lover extends NonPlayerCharacters {
    public Lover(String name, String description){
        super(name, description);
    }

    @Override
    public String interact(Player player){
        String returnMsg = "I am so proud of you!";
        /**
         * your code in here
         */

        return returnMsg;
    }

}
