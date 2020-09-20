package com.loversQuest.gameWorldPieces.models_NPC;
import com.loversQuest.gameWorldPieces.Location;
import com.loversQuest.gameWorldPieces.NonPlayerCharacters;
import com.loversQuest.gameWorldPieces.Player;

public class DrillSGTDicks extends NonPlayerCharacters {

    public DrillSGTDicks(String name, String description, Location location, NPC_Properties properties){
        super(name, description,location, properties);
    }

    @Override
    public String interact(Player player) {
        if (player.isHasCertainItem("Army Marksmanship Expert Badge") && player.isHasCertainItem("Combat Life Saver Badge")
        ){
            return "You seems like a square away soldier, I will recommend you to solider of the month board!";
        } else if (player.isHasCertainItem("Army Marksmanship Expert Badge") || player.isHasCertainItem("Combat Life Saver Badge")) {
            return "Keep up good work! Keeping improving your PT, Markmanship and Expertise!";
        } else {
            return "Privates! the soldier of the month board are for those who have kick ass PT score, sharp at shooting and know their expertise!";
        }
    }
}
