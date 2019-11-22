package gui.buttons;

import database.Database;
import gui.Frame;
import gui.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HighScoresStandardButton extends JButton implements ActionListener {
    private Frame frame;

    public HighScoresStandardButton() {
        super("Standard");
        this.frame = Gui.getGuiInstance().getFrame();
        this.setBackground(new Color(219, 225, 204));
        this.setBounds(110, (frame.getHeight() / 3) - 80, 150, 50);
        this.addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getResultsPanel().resetHsView();
        // Database.getDatabaseInstance().loadFromDatabase("Standard", hs);
    }
}
