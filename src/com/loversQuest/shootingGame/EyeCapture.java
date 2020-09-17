package com.loversQuest.shootingGame;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

public class EyeCapture {

    JLabel Pic; //图片，用于拖动
    JFrame frame;
    JPanel panel;
    static final String eyeCapture = "resources/shootingGameResources/eye_capture.png";

    public EyeCapture()
    {
        frame=new JFrame("图片的拖动");
        ImageIcon eyeC = new ImageIcon(eyeCapture);
        Image eyeCapture = eyeC.getImage().getScaledInstance(20,20,eyeC.getImage().SCALE_DEFAULT);
        Pic = new JLabel(new ImageIcon(eyeCapture));
        panel=new JPanel();
        panel.setBackground(Color.white);
        panel.add(Pic);

        //事件
        MyMouseInputAdapter listener=new MyMouseInputAdapter();  //鼠标事件处理
        Pic.addMouseListener(listener);  //增加标签的鼠标事件处理
        Pic.addMouseMotionListener(listener);

        frame.add(panel);
        frame.setSize(400,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class MyMouseInputAdapter extends MouseInputAdapter {
        Point point=new Point(0,0); //坐标点


        public void mouseMoved(MouseEvent e)
        {
            Point newPoint=SwingUtilities.convertPoint(Pic,e.getPoint(),Pic.getParent()); //转换坐标系统
            Pic.setLocation(Pic.getX()+(newPoint.x-point.x),Pic.getY()+(newPoint.y-point.y)); //设置标签图片的新位置
            point=newPoint; //更改坐标点
        }
    }

    public static void main(String[] args){
        new EyeCapture();
    }
}

