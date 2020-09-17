package com.loversQuest.shootingGame;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class Target extends JButton {
    public static final String targetPath = "resources/shootingGameResources/target.png";
    public static final String hitTargetPath = "resources/shootingGameResources/target_hit.png";

    private int w;
    private int h;
    public static JButton target = new JButton();

    public Target(int w, int h){
        this.w = w;
        this.h = h;
        this.setBounds(0,0,w,h);
        ImageIcon tgtImg = new ImageIcon(targetPath);
        Image tempTgt = tgtImg.getImage().getScaledInstance(this.getWidth(),this.getHeight(),tgtImg.getImage().SCALE_DEFAULT);
        ImageIcon hitImg = new ImageIcon(hitTargetPath);
        Image tempHit = hitImg.getImage().getScaledInstance(this.getWidth(),this.getHeight(),hitImg.getImage().SCALE_DEFAULT);
        this.setIcon(new ImageIcon(tempTgt));
        this.setPressedIcon(new ImageIcon(tempHit));
        this.setBorderPainted(false);


    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

}
