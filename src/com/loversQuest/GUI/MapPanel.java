package com.loversQuest.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Flow;


public class MapPanel extends JPanel{

    MapPanel(){
        ImageIcon image = new ImageIcon("resources/barracks.png");
        JLabel imageLabel = new JLabel(image);
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.add(imageLabel);
        imagePanel.setSize(imageLabel.getWidth(), imageLabel.getHeight());
        JScrollPane scrollPane = new JScrollPane(imagePanel);
        scrollPane.setOpaque(true);
        scrollPane.setPreferredSize(new Dimension (900, 250));
        this.add(scrollPane);
    }
}