package com.loversQuest.miniGame.gymGame;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Racquet {
    // variables
    private static final int Y = 700;
    private static final int WIDTH = 240;
    private static final int HEIGHT = 10;
    int x = 0;
    int xa = 0;
    private PtGame ptGame;

    // ctor
    public Racquet(PtGame ptGame) {
        this.ptGame = ptGame;
    }


    // business methods
    public void move() {
        if (x + xa > 0 && x + xa < ptGame.getWidth() - WIDTH) {
            x = x + xa;
        }
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, Y, WIDTH, HEIGHT);
    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            xa = -ptGame.speed;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            xa = ptGame.speed;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, Y, WIDTH, HEIGHT);
    }

    public int getTopY() {
        return Y;
    }
}
