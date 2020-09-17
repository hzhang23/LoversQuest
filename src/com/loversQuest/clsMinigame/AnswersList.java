package com.loversQuest.clsMinigame;

import java.util.HashMap;

public class AnswersList {

    HashMap<Integer, String> answers = new HashMap<>();

    public AnswersList() {
        answers.put(1, "take cover, return fire, direct him to provide self aid");
        answers.put(2, "the time the tourniquet was applied");
        answers.put(3, "take cover, return fire, provide self aid when able");
        answers.put(4, "check responsiveness");
        answers.put(5, "pain");
        answers.put(6, "play dead");
        answers.put(7, "whether a casualty is breathing or not");
        answers.put(8, "no");
        answers.put(9, "apply direct pressure to the wound, then apply a tourniquet");
        answers.put(10, "shock");
    }

    public HashMap<Integer, String> getAnswers() {
        return answers;
    }
}
