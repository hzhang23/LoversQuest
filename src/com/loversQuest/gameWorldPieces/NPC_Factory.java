package com.loversQuest.gameWorldPieces;

import com.loversQuest.gameWorldPieces.models_NPC.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NPC_Factory {
    private NPC_Factory() {
        //private for static class
    }

    /**
     * construct a Map containing NPC, each NPC able to implements a model
     * @param NpcList generate by readExcel
     * @return
     */

    public static List<NonPlayerCharacters> getNPCs(List<NonPlayerCharacters> NpcList){
        List<NonPlayerCharacters> NpcForGame = new ArrayList<>();
        for(NonPlayerCharacters npc : NpcList){
            NpcForGame.add(getNPC(npc.getName(), npc.getDescription(), npc.getLocationClass(),npc.getProperties()));
        }
        return NpcForGame;
    }

    /**
     * constructs a NPC with a give name and description
     * @param name of Npc
     * @param properties of Npc
     * @param description of Npc
     * @return NPC
     */
    public static NonPlayerCharacters getNPC(String name, String description, Location location, NPC_Properties properties) {
        return getNPCImplementation(name, description, location, properties);
    }

    private static NonPlayerCharacters getNPCImplementation(String name, String description,Location location, NPC_Properties properties){
        NonPlayerCharacters gameNPC;
        switch (properties){
            case LOVER -> gameNPC = new Lover(name,description,location,properties);
            case DRILL_DICKS -> gameNPC = new DrillSGTDicks(name,description,location,properties);
            case DRILL_PT -> gameNPC = new DrillSGT_PT(name,description,location,properties);
            case DRILL_CLS -> gameNPC = new DrillSGT_CLS(name,description,location,properties);
            case DRILL_RANGE -> gameNPC = new DrillSGT_Range(name,description,location,properties);
            case BATTLE_1S1K -> gameNPC = new Battle_1Shot1Kill(name,description,location,properties);
            case BATTLE_PT -> gameNPC = new Battle_PT_Studs(name,description,location,properties);
            case BATTLE_BF -> gameNPC = new Battle_BlueFalcon(name,description,location,properties);
            case BATTLE_SICKCALL -> gameNPC = new Battle_SickRanger(name,description,location,properties);
            case NON_MISSION -> gameNPC = new NonPlayerCharacters(name,description,location,properties);
            default -> gameNPC = new NonPlayerCharacters();
        }
        return gameNPC;
    }

}