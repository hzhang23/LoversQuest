package com.loversQuest.clsMinigame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CLSLandingPage extends JPanel {

  JButton play, exit;
  static boolean go = false;
  public static final int GAME_HEIGHT = 1000;
  public static final int GAME_WIDTH = 1000;

  CLSLandingPage() {
    JFrame gameFrame = new JFrame("quiz game");
    gameFrame.setSize(GAME_WIDTH, GAME_HEIGHT);
    setLayout(null);
    setBackground(Color.DARK_GRAY);
//    window.setContentPane(this);

    play = new JButton("Play");
    play.setBackground(new Color(255, 255, 255));
    play.setBounds(300, 50, 200, 50);
    gameFrame.add(play);

    exit = new JButton("Exit");
    exit.setBackground(new Color(255, 255, 255));
    exit.setBounds(300, 350, 200, 50);
    gameFrame.add(exit);

    gameFrame.setVisible(true);
  }

  void choose(int time) {

    play.addActionListener((ActionEvent e) -> {
      go = true;
      setVisible(true);
    });
  }


  public static void main(String[] args) {
  new CLSLandingPage();
  }
}