package com.loversQuest.gameWorldPieces.models_NPC;

import com.loversQuest.fileHandler.JsonGetter;
import com.loversQuest.gameWorldPieces.Location;
import com.loversQuest.gameWorldPieces.NonPlayerCharacters;
import com.loversQuest.gameWorldPieces.Player;

public class Battle_PT_Studs extends NonPlayerCharacters {

    public Battle_PT_Studs(String name, String description, Location location, NPC_Properties properties){
        super(name, description,location, properties);
    }

    @Override
    public String interact(Player player){
        return JsonGetter.chuckNorrisFact();
    }

}
