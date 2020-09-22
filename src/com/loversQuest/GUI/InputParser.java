package com.loversQuest.GUI;
import com.loversQuest.fileHandler.ExcelManager;

import java.io.*;
import java.util.*;

public class InputParser {
    // David's version of parsing the user command
    //
    public String parseCommand(String command) {
       String result = "";
       File file = new File ("resources/inputWords.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String linesOfSynonyms;
            while ((linesOfSynonyms = br.readLine()) != null) {
                if (linesOfSynonyms.contains(command)) {
                    String[] synonymsArray = linesOfSynonyms.split(",");
                    result = synonymsArray[0];
                    return result;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String[] findMatchObj(String objResponse, String actVerb){
        /**
         * objResponse example : drill sgt, claw, slip, ring
         */
        List<String> screenedList = new ArrayList<>();
        if (actVerb.equals("get") || actVerb.equals("use")){
            actVerb = "get/use";
        }
        Map<String, List<String>> objList= ExcelManager.getGameObjList();
        try {
            List<String> screener = objList.get(actVerb);
            String rawRespone = objResponse.toLowerCase().replaceAll("\\s", "");

            for (String obj : screener){
                String rawObj = obj.toLowerCase().replaceAll("\\s","");
                if (rawObj.contains(rawRespone) && rawRespone != ""){
                    screenedList.add(obj);
                }
            }
            String[] resultArray = screenedList.toArray(new String[0]);
            return resultArray;
        } catch (Exception e){
            String[] result = {"invalid input"};
            return result;
        }
    }

    public String[] userCommandScreening (String[] response) {
        List<String> decorationWords = new ArrayList<>();
        decorationWords.add("the");
        decorationWords.add("to");
        decorationWords.add("a");
        decorationWords.add("again");
        for (String filterWord : decorationWords) {
            for (int i = 0; i < response.length; i++) {
                if (response[i].equals(filterWord)) {
                    response = delete(i, response);
                }
            }
        }
        return response;
    }

    public String[] delete(int index, String array[]){
        String[] newArray = new String[array.length-1];
        for (int i = 0; i < array.length-1; i++){
            if(i < index){
                newArray[i] = array[i];
            } else {
                newArray[i] = array[i+1];
            }
        }
        return newArray;
    }
}

