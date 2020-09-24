package com.loversQuest.miniGame.shootingGame;

import com.loversQuest.GUI.GameFrame;
import com.loversQuest.gameWorldPieces.Item;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Random;

public class RangeGame {

    JLayeredPane layeredPane;
    private int ammoCount;
    ScorePanel scorePanel = new ScorePanel();
    private int targetCount;
    private int targetHit;
    Thread targetThread;
    Target target;
    GameMouse gameMouse = new GameMouse();
    RangePanel bgPanel;
    Random rand = new Random();
    GameFrame gameFrame;
    JFrame rangeFrame;
    JTextArea board = new JTextArea();
    private final File fireSoundFile = new File("resources/shootingGameResources/M4_SOUND.wav");
    private final File reloadFile = new File("resources/shootingGameResources/reload.wav");
    private final File clickFile = new File("resources/shootingGameResources/click.wav");
    boolean isGameOn;
    JButton reLoadBtn;
    JLabel startLabel;


    public RangeGame(GameFrame gameFrame){
        this.gameFrame = gameFrame;
    }

    public void init(){
        rangeFrame = new JFrame();
        ammoCount = 0;
        targetCount = 40;
        targetHit = 0;
        this.getEyeCapture();
        layeredPane = new JLayeredPane();
        reLoadBtn = new JButton("RELOAD");
        ImageIcon btnIcn = new ImageIcon("resources/shootingGameResources/M16icon.png");
        Image btnImage= btnIcn.getImage().getScaledInstance(200,100,btnIcn.getImage().SCALE_DEFAULT);
        ImageIcon reloadIcon = new ImageIcon(btnImage);
        startLabel = new JLabel("Click Reload to Start");
        startLabel.setBounds(400,160, 800,300);
        startLabel.setForeground(Color.ORANGE);
        Font font = new Font("arial", Font.BOLD, 60);
        startLabel.setFont(font);
        reLoadBtn.setIcon(reloadIcon);
        reLoadBtn.setBorderPainted(false);
        reLoadBtn.setBounds(0,0,200,100);
        bgPanel = new RangePanel("resources/shootingGameResources/range1.jpg");
        bgPanel.setBounds(0,0,2000,1100);
        board.setBounds(220,10,500,260);
        board.setText(boardNum());
        layeredPane.add(reLoadBtn,JLayeredPane.MODAL_LAYER);
        layeredPane.add(bgPanel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(board, JLayeredPane.MODAL_LAYER);
        layeredPane.add(startLabel,JLayeredPane.MODAL_LAYER);

        rangeFrame.setTitle("Markmanship Qualification");
        rangeFrame.setAlwaysOnTop(true);
        rangeFrame.setLayeredPane(layeredPane);
        rangeFrame.setLayout(null);
        rangeFrame.setVisible(true);
        rangeFrame.setLocationRelativeTo(null);
        rangeFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        rangeFrame.addMouseListener(gameMouse);
        rangeFrame.addMouseMotionListener(gameMouse);
        rangeFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                RangeGame.this.exitGame();
                RangeGame.this.isGameOn =false;
                targetThread.interrupt();
            }
        });
        rangeFrame.setFocusable(true);
        this.targetUp();
        reLoadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ammoCount != 30){
                 playSound(reloadFile);
                }
                setAmmoCount(30);
                layeredPane.remove(startLabel);
                layeredPane.revalidate();
                layeredPane.repaint();
                RangeGame.this.isGameOn = true;
                RangeGame.this.getEyeCapture();
            }
        });

    }

    public void rifleSound(){
        if (ammoCount > 0){
            playSound(fireSoundFile);
        } else {
            playSound(clickFile);
        }

    }

    public void playSound(File file) {
        Thread soundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                    Clip mySound = AudioSystem.getClip();
                    mySound.open(sound);
                    mySound.start();
                    Thread.sleep(3000);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        if (isGameOn) {
            soundThread.start();
        }
    }

    public void getEyeCapture(){
        Cursor eyeCapture = Cursor.getDefaultCursor();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("resources/shootingGameResources/eye_capture.png");
        Image eyeCap = image.getScaledInstance(50,50,image.SCALE_DEFAULT);
        eyeCapture = toolkit.createCustomCursor(eyeCap, new Point(0, 0), "eyeCapture");
        this.rangeFrame.setCursor(eyeCapture);
    }

    public String boardNum(){
        Font boardFont = new Font("Helvetica", 0, 25);
        board.setFont(boardFont);
        board.setOpaque(false);
        return "You have " + ammoCount + " Bullet \n" + "\nTarget left: " + targetCount + "\n" +
                "Target Hit: " + targetHit;
    }

    public void exitGame(){
        String[] options = {"Clear Weapon and Leave Your Shooting Position!"};
        rangeFrame.dispose();
        scorePanel.scoreField.setText(""+targetHit);
        int flag = JOptionPane.showOptionDialog(null, scorePanel,
                "Shooting Score",JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[0]
                );
        if (flag == 0){
            this.returnGameFrameText();
        }
    }

    // TODO: Get badge from Itemlist instead

    public void returnGameFrameText(){
        if (targetHit > 35) {
            Item expertShooter = new Item("Army Marksmanship Expert Badge", "you feel like your are the most lethal weapon of Army");
            gameFrame.changeTopLeftText("You received this very shiny Expert Badge and you cannot wait to put it on your CLASS A uniform");
            gameFrame.getPlayer().addItem(expertShooter);
        }
        else if (targetHit >= 30 && targetHit <= 35){
            Item sharpShooter = new Item ("Army Marksmanship Sharp Shooter Badge", "you can make things more deader better than most jokers in your platoon");
            gameFrame.changeTopLeftText("Sharpshooter Badge");
            gameFrame.getPlayer().addItem(sharpShooter);
        } else if ( targetHit >= 23 && targetHit < 30) {
            Item weaponQual = new Item("Army Marksmanship Qualification Badge", "at least you hit a bit more than half targets at Range");
            gameFrame.changeTopLeftText("you meet U.S Army minimum requirement just like PVT Carl");
            gameFrame.getPlayer().addItem(weaponQual);

        } else {
            gameFrame.changeTopLeftText("you think you probably need get your eyes checked and try again.");
        }
        gameFrame.refreshPanel();
    }

    public void targetUp(){
        addNewTarget();
        targetThread = new Thread(new Runnable() {
            int t = rand.nextInt(2) + 1;
            @Override
            public void run() {
                while(0 <= t){
                    try {
                        Thread.sleep(1000);
                        t--;
                        if (t == 0){
                            if(targetCount > 0) {
                                targetCount -= 1;
                            }else{
                                exitGame();
                                break;
                            }
                            board.setText(boardNum());
                            layeredPane.remove(target);
                            layeredPane.repaint();
                            addNewTarget();
                            t = rand.nextInt(2) +1;
                        }
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }
        });
        if (isGameOn) {
            targetThread.start();
        }
    }

    private void addNewTarget(){
        // 10 <= x <= 1360
        // 600 <= y <= 750
        int x = rand.nextInt(1350) + 10;
        int y = rand.nextInt(250) + 500;
        target = new Target(100,100);
        layeredPane.add(target, JLayeredPane.POPUP_LAYER);
        target.setLocation(x,y);
        target.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ammoCount > 0) {
                    targetThread.interrupt();
                    targetCount -= 1;
                    ammoCount -= 1;
                    targetHit += 1;
                    board.setText(boardNum());
                    layeredPane.remove(target);
                    layeredPane.repaint();
                    targetUp();
                    rifleSound();
                }
            }
        });
    }


    public int getTargetHit() {
        return targetHit;
    }

    public void setTargetHit(int targetHit) {
        this.targetHit = targetHit;
    }

    public int getAmmoCount() {
        return ammoCount;
    }

    public void setAmmoCount(int ammoCount) {
        this.ammoCount = ammoCount;
    }

    public int getTargetCount() {
        return targetCount;
    }

    public void setTargetCount(int targetCount) {
        this.targetCount = targetCount;
    }

    /**
     * nested class for mouse listener
     */

    private class GameMouse implements MouseListener, MouseMotionListener {

        private int x ;
        private int y ;


        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (ammoCount > 0){
            ammoCount -= 1;}
            board.setText(boardNum());
            RangeGame.this.rifleSound();
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }

        public boolean isGameOn() {
            return isGameOn;
        }

        public void setGameOn(boolean gameOn) {
            isGameOn = gameOn;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
