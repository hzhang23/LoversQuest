package com.loversQuest.clsMinigame;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class AnswersListTest {

    @Test
    public void testGetAnswers() {
        AnswersList theList = new AnswersList();
        HashMap<Integer, String> answers = theList.getAnswers();
        assertEquals(10, answers.size());
    }
}