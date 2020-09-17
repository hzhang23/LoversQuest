package com.loversQuest.gymGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CloseWindow extends JFrame {

    JButton exitBtn;
    JButton restartBtn;

    public CloseWindow (String message) {
        JLabel exitLabel = new JLabel(message);

        exitBtn = new JButton("Exit");
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        restartBtn = new JButton("Restart");
        restartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Calling new game");
                dispose();
            }
        });

        JPanel exitPanel = new JPanel();
        exitPanel.add(exitLabel);
        exitPanel.add(exitBtn);
        exitPanel.add(restartBtn);

        this.add(exitPanel);
        this.setSize(300,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

}
