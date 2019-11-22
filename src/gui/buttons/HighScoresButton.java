package gui.buttons;

import database.Database;
import gui.Frame;
import gui.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HighScoresButton extends JButton implements ActionListener {
    private Frame frame;

    public HighScoresButton() {
        super("High Scores");
        this.frame = Gui.getGuiInstance().getFrame();
        this.setBackground(new Color(219, 225, 204));
        this.setBounds((frame.getWidth() / 2) - 100, (frame.getHeight() / 2) + 40, 200, 50);
        this.addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getMenuPanel().setVisible(false);
        frame.setContentPane(frame.getResultsPanel());
        //Database.getDatabaseInstance().loadFromDatabase("Standard", hs);
        frame.getResultsPanel().setVisible(true);
    }
}
