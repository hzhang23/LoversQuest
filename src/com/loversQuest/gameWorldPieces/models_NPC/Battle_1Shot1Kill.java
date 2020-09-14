package com.loversQuest.gameWorldPieces.models_NPC;

import com.loversQuest.gameWorldPieces.NonPlayerCharacters;
import com.loversQuest.gameWorldPieces.Player;
import com.loversQuest.gameWorldPieces.Location;

public class Battle_1Shot1Kill extends NonPlayerCharacters {
    public Battle_1Shot1Kill(String name, String description){
        super(name, description);
    }

    @Override
    public String interact(Player player){
        String returnMsg = null;
        String npcLocation = this.getLocation().toLowerCase();
        if (npcLocation.equals("range")){
            returnMsg = "one shot, one kill";
        }else {
            returnMsg = "if you could find me my PT belt, I could tell you my serect of 40/40 for markmanship";
        }

        return returnMsg;
    }
}
