package com.loversQuest.gymGame;

import javax.swing.*;

public class Client{

    public Client() {
        JFrame frame = new JFrame("Agility Training Game");
        Game game = new Game();
        frame.add(game);
        frame.setSize(300,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            while (true) {
                game.move();
                game.repaint();
                Thread.sleep(10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}
