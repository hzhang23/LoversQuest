package com.loversQuest.clsMinigame;

import java.util.HashMap;
import java.util.Map;

public class QuestionsList {

    HashMap<Integer, String> questions = new HashMap<Integer, String>();

    public QuestionsList() {
        questions.put(1, "What's the first thing you do when your buddy goes down?");
        questions.put(2, "You apply a tourniquet to your battle-buddy. What are you supposed to write on their forehead?");
        questions.put(3,"You are shot in the leg and are under heavy fire. What should you do?");
        questions.put(4, "What is your first action when you reach a wounded soldier while under fire?");
        questions.put(5, "Your battle is injured but only responds with a wince from a brisk nuggie to his chest. What is this known as on the AVPU scale?");
        questions.put(6, "You've been wounded, are unable to return fire, and there is nowhere nearby to take cover. What should you do?");
        questions.put(7, "The look/listen/feel method is used to determine what?");
        questions.put(8, "A casualty is bleeding severely from a head wound. Should you apply a tourniquet?");
        questions.put(9, "A casualty is bleeding bright red blood from a wound on their thigh. What's the first thing you should do?");
        questions.put(10, "A casualty you're treating has lost a fair amount of blood, looks like a ghost, is mumbling incoherently and is cool and clammy. These are signs of...?");
    }

    public HashMap<Integer, String> getQuestions() {
        return questions;
    }
}
