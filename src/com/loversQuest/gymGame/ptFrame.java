package com.loversQuest.gymGame;

import com.loversQuest.GUI.GameFrame;

import javax.swing.*;

public class ptFrame {
    JFrame ptFrame;
    GameFrame gameFrame;
    Game game;

    public ptFrame(GameFrame gameFrame){
        this.gameFrame = gameFrame;
    }

    public void init() {
        ptFrame = new JFrame("Agility Training Game");
        game = new Game();
        ptFrame.add(game);
        ptFrame.setSize(800,800);
        ptFrame.setLocationRelativeTo(null);
        ptFrame.requestFocus();
        ptFrame.setVisible(true);
        ptFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            while (true) {
                game.move();
                game.revalidate();
                game.repaint();
                Thread.sleep(10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JFrame getPtFrame() {
        return ptFrame;
    }

    public void setPtFrame(JFrame ptFrame) {
        this.ptFrame = ptFrame;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public static void main(String[] args) {

    }
}
