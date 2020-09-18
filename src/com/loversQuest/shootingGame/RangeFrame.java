package com.loversQuest.shootingGame;

import com.loversQuest.gameWorldPieces.models_NPC.DrillSGT_PT;
import com.loversQuest.gameWorldPieces.models_NPC.DrillSGT_Range;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RangeFrame extends JFrame {

    public static void main(String[] args) {
        RangeFrame a = new RangeFrame();
    }
    JLayeredPane layeredPane;
    private int ammoCount;
    private int targetCount;
    private int targetHit;
    Thread targetThread;
    Target target;
    GameMouse gameMouse = new GameMouse();
    RangePanel bgPanel;
    JButton reloadButton;
    Random rand = new Random();
    JFrame main;

    JTextArea textArea = new JTextArea();
    JTextArea board = new JTextArea();

    public RangeFrame(){
        JOptionPane.showMessageDialog(null, "welcome to the Range!","Safety Brief", JOptionPane.PLAIN_MESSAGE);
        ammoCount = 3;
        targetCount = 4;
        targetHit = 0;
        layeredPane = new JLayeredPane();
        bgPanel = new RangePanel("resources/shootingGameResources/range1.jpg");
        bgPanel.setBounds(0,0,2000,1100);
        board.setBounds(10,10,500,260);
        board.setText(boardNum());
        textArea.setBounds(600,0,600,100);
        textArea.setBackground(Color.orange);
        layeredPane.add(bgPanel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(board, JLayeredPane.MODAL_LAYER);
        layeredPane.add(textArea, JLayeredPane.MODAL_LAYER);


       // layeredPane.add(reloadButton, JLayeredPane.MODAL_LAYER);


        this.setTitle("Markmanship Qualification");
        this.targetUp();
        this.setAlwaysOnTop(true);
        this.setLayeredPane(layeredPane);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setCursor(getEyeCapture());
        this.addMouseListener(gameMouse);
        this.addMouseMotionListener(gameMouse);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println(targetHit);
                System.exit(0);
            }
        });
    }

    public Cursor getEyeCapture(){
        Cursor eyeCapture = Cursor.getDefaultCursor();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("resources/shootingGameResources/eye_capture.png");
        Image eyeCap = image.getScaledInstance(50,50,image.SCALE_DEFAULT);
        eyeCapture = toolkit.createCustomCursor(eyeCap, new Point(0, 0), "eyeCapture");
        return eyeCapture;
    }

    public String boardNum(){
        Font boardFont = new Font("Helvetica", 0, 25);
        board.setFont(boardFont);
        board.setOpaque(false);
        return "You have " + ammoCount + " Bullet \n" + "\nTarget left: " + targetCount + "\n" +
                "Target Hit: " + targetHit;
    }

    public void exitGame(){
        this.dispose();
        JOptionPane.showMessageDialog(null, "seize fire! seize fire! seize fire, clear your weapon and get out of my range!", "Shooting Session Completed", JOptionPane.PLAIN_MESSAGE);
        DrillSGT_Range.setShootingScore(targetHit);
        System.out.println(DrillSGT_Range.getShootingScore());
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("resources/shootingGameResources/score.txt"));
            String score = Integer.toString(targetHit);
            writer.write(score);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        targetThread.start();
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

    /**
     * a button to reload
     */
//    public void getReloadButton(){
//        reloadButton = new JButton();
//        ImageIcon icon = new ImageIcon("resources/shootingGameResources/M16icon.png");
//        Image tempTgt = icon.getImage().getScaledInstance(200,100,icon.getImage().SCALE_DEFAULT);
//        reloadButton.setIcon(icon);
//        //reloadButton.setBorderPainted(false);
//        layeredPane.add(reloadButton,JLayeredPane.POPUP_LAYER);
//        reloadButton.setLocation(1600,800);
//        reloadButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                setAmmoCount(30);
//            }
//        });
//    }



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
            String string = "Mouse Location：（" + e.getX() + "，" + e.getY() +"）";
            textArea.setText(string);

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
