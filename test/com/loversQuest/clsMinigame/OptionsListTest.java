package com.loversQuest.clsMinigame;

import org.junit.Test;


import java.util.HashMap;

import static org.junit.Assert.*;

public class OptionsListTest {

    @Test
    public void testGetOptions() {
        OptionsList theList = new OptionsList();
        HashMap<Integer, String[]> options = theList.getOptions();
        assertEquals(10, options.size());
    }
}