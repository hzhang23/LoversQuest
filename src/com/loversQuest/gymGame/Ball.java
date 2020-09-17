package com.loversQuest.gymGame;

import java.awt.*;
import java.util.Random;

public class Ball {
    private static final int DIAMETER = 30;
    Random rand = new Random();
    int x = rand.nextInt(300);
    int y = 0;
    int xa = 1;
    int ya = 1;
    private Game game;

    public Ball(Game game) {
        this.game = game;
    }

    void move() {
        if (x + xa < 0) {
            xa = game.speed;
        }
        else if (x + xa > game.getWidth() - DIAMETER) {
            xa = -game.speed;
        }
        else if (y + ya < 0) {
            ya = game.speed;
        }
        else if (y + ya > game.getHeight() - DIAMETER) {
            game.gameOver();
        }
        else if (collision()) {
            ya = -game.speed;
            y = game.racquet.getTopY() - DIAMETER;
            game.speed++;
        }

        x = x + xa;
        y = y + ya;
    }

    private boolean collision() {
        return game.racquet.getBounds().intersects(getBounds());
    }

    public void paint(Graphics2D g) {
        g.fillOval(x, y, 30, 30);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}
