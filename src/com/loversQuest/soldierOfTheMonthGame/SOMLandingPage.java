package com.loversQuest.soldierOfTheMonthGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SOMLandingPage extends JPanel {
  public static final int GAME_WIDTH = 600;
  public static final int GAME_HEIGHT = 600;

  JButton play, exit, how;
  static boolean go = false;

  SOMLandingPage(JFrame window) {
    window.setSize(GAME_WIDTH, GAME_HEIGHT);
    setLayout(null);
    setBackground(Color.DARK_GRAY);
    window.setContentPane(this);

    JLabel welcomeLabel = new JLabel("Welcome to the Soldier of the Month Board!");
    welcomeLabel.setFont(new Font("Verdana", Font.BOLD, 20));
    welcomeLabel.setBounds(40,5,533,40);
    welcomeLabel.setForeground(Color.white);
    add(welcomeLabel);

    play = new JButton("Play");
    play.setBackground(new Color(255, 255, 255));
    play.setBounds(25, 80, 533, 150);
    add(play);

    how = new JButton ("How It Works");
    how.setBackground(new Color(255,255,255)) ;
    how.setBounds(25,240,533,150);
    add(how);

    exit = new JButton("Exit");
    exit.setBackground(new Color(255, 255, 255));
    exit.setBounds(25, 400, 533, 150);
    add(exit);


    window.setVisible(true);
  }

  void choose(int time) {
    play.addActionListener((ActionEvent e) -> {
      go = true;
      setVisible(false);
    });

    how.addActionListener((ActionEvent e) -> {
      new SOMHowItWorks(time);
    });

    exit.addActionListener((ActionEvent e) -> {
      System.exit(0);
    });

    while (!go) {
      try {
        Thread.sleep(0);
      } catch (InterruptedException ex) {}
    }
    go = false ;
  }
}