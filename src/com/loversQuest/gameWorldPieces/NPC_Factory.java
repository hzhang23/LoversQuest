package com.loversQuest.gameWorldPieces;

import com.loversQuest.gameWorldPieces.models_NPC.*;

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

    public static Map<NPC_Properties, NonPlayerCharacters> getNPCs(List<NonPlayerCharacters> NpcList){
        Map<NPC_Properties,NonPlayerCharacters> NpcForGame = new HashMap<>();
        for(NonPlayerCharacters npc : NpcList){
            NpcForGame.put(npc.getProperties(), getNPC(npc.getName(), npc.getDescription(),npc.getProperties()) );
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
    public static NonPlayerCharacters getNPC(String name, String description, NPC_Properties properties) {
        return getNPCImplementation(name, description, properties);
    }

    private static NonPlayerCharacters getNPCImplementation(String name, String description, NPC_Properties properties){
        NonPlayerCharacters gameNPC = null;
        switch (properties){
            case LOVER -> gameNPC = new Lover(name, description);
            case DRILL_DICKS -> gameNPC = new DrillSGTDicks(name, description);
            case DRILL_PT -> gameNPC = new DrillSGT_PT(name, description);
            case DRILL_LANDNAV -> gameNPC = new DrillSGT_LandNav(name, description);
            case DRILL_RANGE -> gameNPC = new DrillSGT_Range(name, description);
            case BATTLE_1S1K -> gameNPC = new Battle_1Shot1Kill(name, description);
            case Battle_PT -> gameNPC = new Battle_BlueFalcon(name, description);
            case Battle_BF -> gameNPC = new Battle_BlueFalcon(name, description);
            case BATTLE_SICKCALL -> gameNPC = new Battle_SickRanger(name, description);
        }
        return gameNPC;
    }

}