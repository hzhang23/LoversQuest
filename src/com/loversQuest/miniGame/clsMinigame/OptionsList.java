package com.loversQuest.miniGame.clsMinigame;

import java.util.HashMap;

public class OptionsList {
    HashMap<Integer, String[]> options = new HashMap<Integer, String[]>();

    public OptionsList() {
        options.put(1, new String[] {"take cover, return fire, direct him to provide self aid", "tell him to 'hop on, buddy ol' pal!", "ditch him", "call for medic"});
        options.put(2, new String[] {"their unit", "their injury", "the time the tourniquet was applied", "all of the above"});
        options.put(3, new String[] {"provide self aid", "call for the medic", "tell the enemy to 'hol up!'", "take cover, return fire, and provide self aid when able"});
        options.put(4, new String[] {"check pockets for MRE goodies", "check responsiveness", "take their ammo and weapons", "ask them, 'whodunnit?"});
        options.put(5, new String[] {"alert", "verbal", "pain", "unresponsive"});
        options.put(6, new String[] {"play dead", "surrender", "pretend you're not a combatant", "snap and say 'oh hell naw'"});
        options.put(7, new String[] {"tremors... those dang worm things!", "if there are nearby troops", "whether you are upwind or downwind from the enemy", "whether a casualty is breathing or not"});
        options.put(8, new String[] {"yes", "no", "yes, pop that head like a pimple", "iono"});
        options.put(9, new String[] {"determine if they're responsive", "ask if they want anything from the grocery store", "apply a tourniquet", "apply direct pressure to the wound, then apply a tourniquet"});
        options.put(10, new String[] {"REM sleep", "elation from being MEDEVAC'd", "shock", "dat special sauce"});
    }

    public HashMap<Integer, String[]> getOptions() {
        return options;
    }
}
