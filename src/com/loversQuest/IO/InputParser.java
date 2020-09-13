package com.loversQuest.IO;
import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class InputParser {

    // takes in a word and looks for a matching command word
    public String parseCommand(String command) {
        try{
            //read in csv file
//            DataInputStream in = new DataInputStream(getClass().getResourceAsStream("inputWords.txt"));
            DataInputStream in = new DataInputStream(getClass().getResourceAsStream("Utilities/inputWords.txt"));
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


    // find the line number

    // read that line

    // return the first word of that line
}
