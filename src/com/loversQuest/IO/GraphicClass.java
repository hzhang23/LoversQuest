package com.loversQuest.IO;

import com.loversQuest.gameWorldPieces.Location;

import java.io.*;

public class GraphicClass {
    //    Business Method
    public void printLocation(String filename) throws IOException {
        String fileLocation = "images/" + filename;
        DataInputStream in = new DataInputStream(getClass().getResourceAsStream(fileLocation));
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = br.readLine()) != null) {
            //process the line
            System.out.println(line);
        }
    }
}




