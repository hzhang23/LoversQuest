package com.loversQuest.IO;
import com.loversQuest.excelReader.ReadExcel;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class InputParser {

    // takes in a word and looks for a matching command word
    public String parseCommand(String command) {
        try{
            //read in csv file
//            DataInputStream in = new DataInputStream(getClass().getResourceAsStream("inputWords.txt"));
            DataInputStream in = new DataInputStream(getClass().getResourceAsStream("Utilities/inputWfords.txt"));
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

            //continue to read in file while lines exist
            while ((strLine = br.readLine()) != null){
                //split file into a list of words
                String[] words = strLine.split(",");
                //create an array list of command words
                ArrayList<String> commandWords = new ArrayList<>(Arrays.asList(words));
                //programmed word is first word of a line, if input word is found on same line,
                //  return the programmed command word.
                if(commandWords.contains(command)){
                    return commandWords.get(0);
                }
            }

            in.close();
        }catch (Exception e){
            e.printStackTrace();
//            System.err.println("error: " + e.getMessage());
        }

        // return non command sensitive string if command word not found
        return "Command not found";
    }

    public boolean isInFile(String command, Scanner file) {
        try {
            List<String> wordsList = new ArrayList<>();
            for (int i = 0; file.hasNextLine() != false; i++) {
                wordsList.add(file.nextLine());
                if (wordsList.get(i).contains(command)) {
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    // my version of parsing the user command
    //
    public String parseCommand2(String command) {
       String result = "";
       File file = new File ("src/com/loversQuest/IO/Utilities/inputWords.txt");
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
        Map<String, List<String>> objList=ReadExcel.getGameObjList();
        List<String> screener = objList.get(actVerb);
        String rawRespone = objResponse.toLowerCase().replaceAll("\\s", "");

        for (String obj : screener){
            String rawObj = obj.toLowerCase().replaceAll("\\s","");
            if (rawObj.contains(rawRespone) && rawRespone != ""){
                screenedList.add(obj);
            }
        }
        String[] resultArray = screenedList.toArray(new String[0]);
        System.out.println(resultArray);
        return resultArray;
    }

    public String[] userCommandScreening (String[] response) {
        List<String> decorationWords = new ArrayList<>();
        decorationWords.add("the");
        decorationWords.add("to");
        decorationWords.add("a");
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

