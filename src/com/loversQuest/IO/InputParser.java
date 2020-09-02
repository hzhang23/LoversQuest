package com.loversQuest.IO;
import java.io.*;
import java.util.*;

public class InputParser {

    // takes in a word and looks for a matching command word
    public String parseCommand(String command) {
        try{
            //read in csv file
            DataInputStream in = new DataInputStream(getClass().getResourceAsStream("inputWords.txt"));
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
            System.err.println("error: " + e.getMessage());
        }

        // return non command sensitive string if command word not found
        return "Command not found";


    }

    public static void main(String[] args) {
        InputParser test = new InputParser();
        System.out.println(test.parseCommand("beta"));
    }
}
