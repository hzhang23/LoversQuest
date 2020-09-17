package com.loversQuest.shootingGame;

import org.apache.poi.ss.formula.functions.T;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RangeFrame extends JFrame {
    public RangeFrame(){
        Container contentPane = this.getContentPane();
        this.setTitle("Markmanship Qualification");
        this.addNewTarget();
        contentPane.setLayout(null);

        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("resources/shootingGameResources/eye_capture.png");
        Image eyeCap = image.getScaledInstance(100,100,image.SCALE_DEFAULT);
        Cursor eyeCapture = toolkit.createCustomCursor(eyeCap, new Point(10,10),"eyeCapture");
        this.setCursor(eyeCapture);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

    private void addNewTarget(){
        Random rand = new Random();
        int x = rand.nextInt(1000);
        int y = rand.nextInt(1000);
        Target target = new Target(100,100);
        this.getContentPane().add(target);
        target.setLocation(x,y);
        target.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeItems();
                addNewTarget();
            }
        });

    }

    public void removeItems(){
        this.getContentPane().removeAll();
        this.getContentPane().repaint();
    }

    public static void main(String[] args) {
        new RangeFrame();
    }


}
