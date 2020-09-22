package com.loversQuest;

import com.loversQuest.GUI.GameFrame;
import com.loversQuest.GUI.JFrameInput;
import com.loversQuest.IO.Output;
import com.loversQuest.excelReader.ReadExcel;
import com.loversQuest.gameWorldPieces.Location;
import com.loversQuest.gameWorldPieces.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

public class StartPanel extends JPanel {
    private static String startImage = "resources/start_image.jpg";
    JFrame startFrame;
    //ctor
    public StartPanel(){
        startFrame = new JFrame("Love Quest");
        JLabel title = new JLabel("Love Quest");
        title.setBounds(40,10,900,100);
        Font font = new Font("Comic Sans MS", Font.ITALIC + Font.BOLD, 99);
        title.setFont(font);
        title.setForeground(Color.white);
        MyButton startBtn = new MyButton("New Story");
        MyButton resumeBtn = new MyButton("Resume a Story");
        startBtn.setBounds(550,150,300,100);
        resumeBtn.setBounds(550,300,300,100);
        this.setLayout(null);
        this.add(startBtn);
        this.add(resumeBtn);
        startFrame.add(title);
        startFrame.add(this);
        startFrame.setSize(900,600);
        startFrame.setLocationRelativeTo(null);
        startFrame.setVisible(true);
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameInit();
                startFrame.dispose();
            }
        });
    }


    public void gameInit(){
        GameInit g1 = new GameInit();
        Output output = new Output();
        JFrameInput jFrameInput = new JFrameInput();
        GameFrame gameFrame = new GameFrame(output.displayIntroDialog(), jFrameInput, g1.p1);
        gameFrame.changeTopRightText("This is your rucksack.\nIn it you will find all the items you are currently carrying and can use.\n" +
                "Below is the command window. Enter any of the commands listed. You may also maneuver using the arrow keys.");
    }

    //Business Methods
    @Override
    public void paintComponent(Graphics graph){
        super.paintComponent(graph);
        ImageIcon bgImg = new ImageIcon(startImage);
        graph.drawImage(bgImg.getImage(),0,0, this.getWidth(),this.getHeight(),bgImg.getImageObserver());
    }


    private class MyButton extends JButton{

        public MyButton(String name){
            MyButton.this.setText(name);
            MyButton.this.setMargin(new Insets(0,0,0,0));
            MyButton.this.setForeground(Color.white);
            MyButton.this.setBorder(BorderFactory.createLineBorder(Color.white, 3));
            MyButton.this.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    MyButton.this.setForeground(Color.orange);
                }
                @Override
                public void mouseReleased(MouseEvent e) {
                    MyButton.this.setForeground(Color.white);
                }
            });
            Font fontBtn = new Font("Comic Sans MS", Font.ITALIC + Font.BOLD, 30);
            MyButton.this.setFont(fontBtn);
        }
    }

    public static void main(String[] args) {
       new StartPanel();


    }


}
