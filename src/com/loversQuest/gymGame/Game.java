package com.loversQuest.gymGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel {

    // variables

    Ball ball = new Ball(this);
    Racquet racquet = new Racquet(this);
    int speed = 1;

    // ctor
    public Game() {

       addKeyListener(new KeyListener() {
           @Override
           public void keyTyped(KeyEvent e) {
           }

           @Override
           public void keyPressed(KeyEvent e) {
                racquet.keyReleased(e);
           }

           @Override
           public void keyReleased(KeyEvent e) {
                racquet.keyPressed(e);
           }
       });
       setFocusable(true);
    }

    // methods

    private int getScore() {
        return speed - 1;
    }

    public void move() {
       ball.move();
       racquet.move();
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);
        racquet.paint(g2d);

        g2d.setColor(Color.GRAY);
        g2d.setFont(new Font("Verdana", Font.BOLD, 30));
        g2d.drawString(String.valueOf(getScore()), 10, 30);
    }

    public void gameOver() {
        int response = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Game Over",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.NO_OPTION) {
            System.exit(0);
        }
        else if (response == JOptionPane.YES_OPTION) {
           JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
           frame.dispose();
           new Client();
        }
        else if (response == JOptionPane.CLOSED_OPTION) {
            System.exit(0);
        }
    }
}
