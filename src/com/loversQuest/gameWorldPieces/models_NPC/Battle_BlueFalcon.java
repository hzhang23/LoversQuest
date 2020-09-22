package com.loversQuest.gameWorldPieces.models_NPC;

import com.loversQuest.fileHandler.JsonGetter;
import com.loversQuest.gameWorldPieces.Location;
import com.loversQuest.gameWorldPieces.NonPlayerCharacters;
import com.loversQuest.gameWorldPieces.Player;

public class Battle_BlueFalcon extends NonPlayerCharacters {

    public Battle_BlueFalcon(String name, String description, Location location, NPC_Properties properties) {
        super(name, description, location, properties);
    }

    @Override
    public String interact(Player player) {
        return JsonGetter.getRandomFact();
    }
}
