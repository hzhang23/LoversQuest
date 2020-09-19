package com.loversQuest.gymGame;

import com.loversQuest.GUI.GameFrame;

import javax.swing.*;

public class PtGame {
    JFrame ptGameFrame;
    GameFrame gameFrame;
    Game game;

    public PtGame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }


    public void init() {
        ptGameFrame = new JFrame("Agility Training Game");
        game = new Game();
        ptGameFrame.add(game);
        ptGameFrame.setSize(300, 400);
        ptGameFrame.setVisible(true);
        ptGameFrame.setAlwaysOnTop(true);
        ptGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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


    public JFrame getPtGameFrame() {
        return ptGameFrame;
    }

    public void setPtGameFrame(JFrame ptGameFrame) {
        this.ptGameFrame = ptGameFrame;
    }


    public void gameOver() {
        int response = JOptionPane.showConfirmDialog(null, "You scored " + this.getGame().getScore() + " points. You need at least 5. Do you want to play again?", "Game Over",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.NO_OPTION) {
            System.exit(0);
        } else if (response == JOptionPane.YES_OPTION) {
            this.getPtGameFrame().dispose();
            this.init();
        } else if (response == JOptionPane.CLOSED_OPTION) {
            System.exit(0);
        }
    }




    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public static void main(String[] args) {

        //new PtGame();
    }
}
