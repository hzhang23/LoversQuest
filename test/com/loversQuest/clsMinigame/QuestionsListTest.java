package com.loversQuest.clsMinigame;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class QuestionsListTest {

    @Test
    public void testGetQuestions() {
        QuestionsList theList = new QuestionsList();
        HashMap<Integer, String> questions = theList.getQuestions();
        assertEquals(10, questions.size());
    }
}