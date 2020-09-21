package com.loversQuest.clsMinigame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CLSLandingPage extends JPanel {
  public static final int GAME_WIDTH = 600;
  public static final int GAME_HEIGHT = 600;

  JButton play, exit;
  static boolean go = false;

  CLSLandingPage(JFrame window) {
    window.setSize(GAME_WIDTH, GAME_HEIGHT);
    setLayout(null);
    setBackground(Color.DARK_GRAY);
    window.setContentPane(this);


    play = new JButton("Play");
    play.setBackground(new Color(255, 255, 255));
    play.setBounds(25, 100, 533, 200);
    add(play);

    exit = new JButton("Exit");
    exit.setBackground(new Color(255, 255, 255));
    exit.setBounds(25, 300, 533, 200);
    add(exit);


    window.setVisible(true);
  }

  void choose(int time) {
    play.addActionListener((ActionEvent e) -> {
      go = true;
      setVisible(false);
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