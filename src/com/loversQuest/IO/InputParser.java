package com.loversQuest.IO;
import java.io.*;
import java.util.*;

public class InputParser {

    // takes in a word and looks for a matching command word
    public String parseCommand(String command) {
        try{
            //read in csv file
//            DataInputStream in = new DataInputStream(getClass().getResourceAsStream("inputWords.txt"));
            DataInputStream in = new DataInputStream(getClass().getResourceAsStream("Utilities/inputWords.txt"));
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine = null;

            // continue to read in file while lines exist
            while ((strLine = br.readLine()) != null){
                // split file into a list of words
                String wordsOnSameLine = br.readLine();

                // split words into an array
                String[] wordsArray = wordsOnSameLine.split(",");

                // put it into an ArrayList
                ArrayList<String> commandWords = new ArrayList<>(Arrays.asList(wordsArray));

                //programmed word is first word of a line, if input word is found on same line,
                //  return the programmed command word.
                if(wordsOnSameLine.contains(command)){
//                    System.out.println("HERE!!!");
//                    System.out.println(strLine);
//                    System.out.println(wordsOnSameLine);
                    return commandWords.get(0);
                }
            }

            in.close();
        }catch (Exception e){
            System.err.println("error: " + e.getMessage());
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


    // find the line number

    // read that line

    // return the first word of that line
}
