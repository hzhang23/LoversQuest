package com.loversQuest.miniGame.gymGame;

import java.awt.*;
import java.util.Random;

public class Ball {
    private static final int DIAMETER = 50;
    Random rand = new Random();
    int x = rand.nextInt(300);
    int y = 0;
    int xa = 2;
    int ya = 2;
    private PtGame ptGame;

    public Ball(PtGame ptGame) {
        this.ptGame = ptGame;
    }

    void move() {
        if (x + xa < 0) {
            xa = ptGame.speed;
        }
        else if (x + xa > ptGame.getWidth() - DIAMETER) {
            xa = -ptGame.speed;
        }
        else if (y + ya < 0) {
            ya = ptGame.speed;
        }
        else if (y + ya > ptGame.getHeight() - DIAMETER) {
            ptGame.isSatisfied();
        }
        else if (collision()) {
            ya = -ptGame.speed;
            y = ptGame.racquet.getTopY() - DIAMETER;
            ptGame.speed++;
        }

        x = x + xa;
        y = y + ya;
    }

    private boolean collision() {
        return ptGame.racquet.getBounds().intersects(getBounds());
    }

    public void paint(Graphics2D g) {
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}
