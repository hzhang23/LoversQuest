package com.loversQuest.shootingGame;

import org.apache.poi.ss.formula.functions.T;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class RangeFrame extends JFrame {
    JLayeredPane layeredPane;
    private int ammoCount;
    private int targetCount;
    GameMouse gameMouse = new GameMouse();
    RangePanel bgPanel;
    JButton reloadButton;

    JTextArea textArea = new JTextArea();
    JTextArea board = new JTextArea();

    public RangeFrame(){
        ammoCount = 30;
        targetCount = 40;
        layeredPane = new JLayeredPane();
        bgPanel = new RangePanel("resources/shootingGameResources/range1.jpg");
        bgPanel.setBounds(0,0,2000,1100);
        board.setBounds(10,10,500,100);
        board.setText(boardNum());
        textArea.setBounds(600,0,600,100);
        textArea.setBackground(Color.orange);


        layeredPane.add(bgPanel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(board, JLayeredPane.MODAL_LAYER);
        layeredPane.add(textArea, JLayeredPane.MODAL_LAYER);


       // layeredPane.add(reloadButton, JLayeredPane.MODAL_LAYER);





        this.setTitle("Markmanship Qualification");
        this.addNewTarget();



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
                System.exit(0);
            }
        });

    }

    public Cursor getEyeCapture(){
        Cursor eyeCapture = Cursor.getDefaultCursor();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("resources/shootingGameResources/eye_capture.png");
        Image eyeCap = image.getScaledInstance(50,50,image.SCALE_DEFAULT);
        eyeCapture = toolkit.createCustomCursor(eyeCap, new Point(10, 10), "eyeCapture");
        return eyeCapture;
    }

    public String boardNum(){
        Font boardFont = new Font("Helvetica", 0, 30);
        board.setFont(boardFont);
        board.setOpaque(false);
        return "You have " + ammoCount + " bullet \n" + "\ntarget left: " + targetCount;
    }

    private void addNewTarget(){
        Random rand = new Random();
        // 10 <= x <= 1700
        // 600 <= y <= 850

        int x = rand.nextInt(1690) + 10;
        int y = rand.nextInt(250) + 600;
        Target target = new Target(100,100);
        layeredPane.add(target, JLayeredPane.POPUP_LAYER);
        target.setLocation(x,y);
        target.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                targetCount -= 1;
                ammoCount -= 1;
                board.setText(boardNum());
                layeredPane.remove(target);
                layeredPane.repaint();
                addNewTarget();
            }
        });
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
            ammoCount -= 1;
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

    public static void main(String[] args) {
        new RangeFrame();
    }


}
