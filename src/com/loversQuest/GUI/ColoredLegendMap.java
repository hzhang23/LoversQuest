package com.loversQuest.GUI;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;

// ColoredLegendMap will display items, locations, and characters in colored text.
public class ColoredLegendMap extends JPanel {

    private JTextPane legendTextPane = new JTextPane();

    ColoredLegendMap() {

        JLabel legendMapLabel = new JLabel("LEGEND with COLORS!");
        legendMapLabel.setFont(new Font("Comic Sans", Font.BOLD, 35));
        this.add(legendMapLabel);

        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
        StyleConstants.setBold(attributeSet, true);

        // within this panel, id like to display
        // how to import current games player intance?

        // Player.CurrentLocation = blue
        // Player.Current.location.Items = purple
        // player.current.location.npc = green
        // Player.currentlocation.mysteryitems = red

    }
}
