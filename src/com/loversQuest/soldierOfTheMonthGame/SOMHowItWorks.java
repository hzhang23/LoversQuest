package com.loversQuest.soldierOfTheMonthGame;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

public class SOMHowItWorks extends JFrame {

  SOMHowItWorks(int time) {
    setSize(400,400);
    setLocationRelativeTo(null);
    setResizable(false);
    JPanel howItWorksPanel = new JPanel() ;
    howItWorksPanel.setSize(this.getSize().width,this.getSize().height);
    howItWorksPanel.setBackground(Color.DARK_GRAY);
    howItWorksPanel.setLayout(null);
    setContentPane(howItWorksPanel);
    JTextArea howLabel = new JTextArea("You have 60 seconds to answer 8 questions on Amazon's Leadership Principles. \n"
        + "You must get 6 out of 8 correct in order to be named Soldier of the Month. Good luck!");
    howLabel.setFont(new Font("Verdana", Font.BOLD, 20));
    howLabel.setBounds(8,5,350,350);
    howLabel.setEditable(false);
    howLabel.setLineWrap(true);
    howLabel.setWrapStyleWord(true);
    JLabel border = new JLabel();
    border.setBorder(new LineBorder(Color.white, 2, true));
    border.setBounds(10,5,365,350);
    border.add(howLabel);
    howItWorksPanel.add(border);
    setVisible(true);
  }
}

