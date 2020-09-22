
package com.loversQuest.miniGame.gymGame;

import com.loversQuest.GUI.GameFrame;
import com.loversQuest.gameWorldPieces.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PtGame extends JPanel {

    // variables
    JFrame ptFrame;
    GameFrame gameFrame;
    Ball ball = new Ball(this);
    Racquet racquet = new Racquet(this);
    int speed = 2;
    boolean isGameRun = true;


    // methods
    public void init() {
        ptFrame = new JFrame("Agility Training PtGame");
        ptFrame.add(this);
        ptFrame.setSize(800,800);
        ptFrame.setLocationRelativeTo(null);
        ptFrame.requestFocus();
        ptFrame.setVisible(true);
        ptFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            while (isGameRun) {
                this.move();
                this.revalidate();
                this.repaint();
                Thread.sleep(10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // ctor
    public PtGame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                racquet.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                racquet.keyReleased(e);
            }
        });
        setFocusable(true);
    }

    public int getScore() {
        return speed - 1;
    }

    public void move() {
        ball.move();
        racquet.move();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);
        racquet.paint(g2d);

        g2d.setColor(Color.GRAY);
        g2d.setFont(new Font("Verdana", Font.BOLD, 30));
        g2d.drawString(String.valueOf(getScore()), 10, 30);
    }


    // checking if the player has satisfied requirement to complete the task
    public void isSatisfied() {
        String passOrfail = null;
        if (this.getScore() >= 5){
            passOrfail = "Passed";
        } else {
            passOrfail = "failed";
        }
        String[] options = {"PT test Complete"};
        int response = JOptionPane.showOptionDialog(null, "PT test completed, you " + passOrfail, "PT test result",
                JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (response == 0) {
            if(this.getScore() >= 5){
                Item ptBadge = new Item ("Physical Training Badge", "You showed up for the pt test");
                gameFrame.changeTopLeftText("you passed! congrats!");
                gameFrame.getPlayer().addItem(ptBadge);
                gameFrame.refreshPanel();
            } else {
                gameFrame.changeTopLeftText("you failed! now you need to go to Porta Johns for clean details");
                gameFrame.getPlayer().go("north");
                gameFrame.refreshPanel();
            }
            ptFrame.dispose();
            setGameRun(false);
        }
    }

    public boolean isGameRun() {
        return isGameRun;
    }

    public void setGameRun(boolean gameRun) {
        isGameRun = gameRun;
    }


}

