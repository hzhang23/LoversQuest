package com.loversQuest.gameWorldPieces.models_NPC;

import com.loversQuest.gameWorldPieces.Location;
import com.loversQuest.gameWorldPieces.NonPlayerCharacters;
import com.loversQuest.gameWorldPieces.Player;

public class Lover extends NonPlayerCharacters {
    public Lover(String name, String description, Location location, NPC_Properties properties){
        super(name, description,location, properties);
    }

    @Override
    public String interact(Player player){
        String returnMsg = "I am so proud of you!";
        if(player.isHasCertainItem("diamond ring")){
            returnMsg = "happyEnding";
        }else{
            returnMsg = "do you want to move out of the barracks? just put a ring on me!";
        }
        return returnMsg;
    }

}
