package com.loversQuest.gameWorldPieces.models_NPC;

import com.loversQuest.GUI.GameFrame;
import com.loversQuest.clsMinigame.CLSGame;
//import com.loversQuest.clsMinigame.CombatLifeSaverMinigame;
import com.loversQuest.gameWorldPieces.Item;
import com.loversQuest.gameWorldPieces.Location;
import com.loversQuest.gameWorldPieces.NonPlayerCharacters;
import com.loversQuest.gameWorldPieces.Player;

import java.util.List;
import java.util.Scanner;

public class DrillSGT_CLS extends NonPlayerCharacters {

    private String clsBadge = "combat life saver badge";

    public DrillSGT_CLS(String name, String description, Location location, NPC_Properties properties){
        super(name, description,location, properties);
    }

    @Override
    public String interact(Player player) {
//        Scanner sc = new Scanner(System.in);
        String returnMsg = null;
        if(player.isHasCertainItem(clsBadge)){
            returnMsg = "Good work, Private! What a shiny badge!";
        }else {
            returnMsg = "Private! Time to check your CLS knowledge! Don't tell me that you still use duct tape for everything!";
//            String goOrNo = sc.next().toLowerCase().strip();
//            if (goOrNo.equals("yes")) {
//                CLSGame game = CombatLifeSaverMinigame.getInstance();
//                game.clsGame(player);
//                if (goOrNo != "yes" || goOrNo != "no") {
//                    System.out.println("Get it together, fam!");
//                }
//            } else {
//                return returnMsg;
//            }
        }
        return returnMsg;
    }
}
