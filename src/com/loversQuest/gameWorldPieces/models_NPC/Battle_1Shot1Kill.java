package com.loversQuest.gameWorldPieces.models_NPC;

import com.loversQuest.fileHandler.JsonGetter;
import com.loversQuest.gameWorldPieces.NonPlayerCharacters;
import com.loversQuest.gameWorldPieces.Player;
import com.loversQuest.gameWorldPieces.Location;

public class Battle_1Shot1Kill extends NonPlayerCharacters {
    public Battle_1Shot1Kill(String name, String description, Location location, NPC_Properties properties){
        super(name, description,location, properties);
    }

    @Override
    public String interact(Player player){
        return JsonGetter.kanyeQuotes();
    }
}
