package com.loversQuest.GUI;


import javax.swing.*;

public class JPanelFactory {
    private JFrame mainFrame;

    JPanelFactory(JFrame mainFrame){
        this.mainFrame = mainFrame;
    }
    public InventoryPanel getInventoryPanel(){
        return new InventoryPanel(this.mainFrame.getX(), this.mainFrame.getY());
    }

    public GameResponsePanel getGameResponsePanel(){
        return new GameResponsePanel(this.mainFrame.getX(), this.mainFrame.getY());
    }

    public InputPanel getInputPanel(){
        return new InputPanel(mainFrame);
    }

    public MapPanel getMapPanel(){
        return new MapPanel(mainFrame);
    }

    public ColoredLegendMap getLegendPanel() {
        return new ColoredLegendMap();
    }
}
