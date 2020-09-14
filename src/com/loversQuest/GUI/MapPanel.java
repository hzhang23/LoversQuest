package com.loversQuest.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Flow;


public class MapPanel extends JPanel{


    public MapPanel(String location){
        String locationName = this.findPlayerLocation(location);
        System.out.println("NAME to PASS is: " + locationName);
        String fileName = String.format("resources/%s.png", locationName);
        System.out.println("FILENAME is : " + fileName);
        ImageIcon image = new ImageIcon(fileName);
        JLabel imageLabel = new JLabel(image);
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.add(imageLabel);
        imagePanel.setSize(imageLabel.getWidth(), imageLabel.getHeight());
        JScrollPane scrollPane = new JScrollPane(imagePanel);
        scrollPane.setOpaque(true);
        scrollPane.setPreferredSize(new Dimension (900, 250));
        this.add(scrollPane);
    }

    public String findPlayerLocation(String location) {
        String lowercasedLocationName = location.toLowerCase();
        System.out.println(lowercasedLocationName);
        return lowercasedLocationName;
    }
}