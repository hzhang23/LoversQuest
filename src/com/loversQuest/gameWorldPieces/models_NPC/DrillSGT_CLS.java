package com.loversQuest.gameWorldPieces.models_NPC;

//import com.loversQuest.miniGame.clsMinigame.CombatLifeSaverMinigame;
import com.loversQuest.fileHandler.JsonGetter;
        import com.loversQuest.gameWorldPieces.Location;
import com.loversQuest.gameWorldPieces.NonPlayerCharacters;
import com.loversQuest.gameWorldPieces.Player;

public class DrillSGT_CLS extends NonPlayerCharacters {

    public DrillSGT_CLS(String name, String description, Location location, NPC_Properties properties){
        super(name, description,location, properties);
    }

    @Override
    public String interact(Player player) {
        String returnMsg = null;
        if(player.isHasCertainItem("combat life saver badge")){
            returnMsg = JsonGetter.getStarWarAPI();
        }else {
            returnMsg = "miniGameInit";
        }
        return returnMsg;
    }
}
