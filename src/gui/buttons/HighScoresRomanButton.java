package gui.buttons;

import gui.Frame;
import gui.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HighScoresRomanButton extends JButton implements ActionListener {
    private Frame frame;

    public HighScoresRomanButton() {
        super("Roman");
        this.frame = Gui.getGuiInstance().getFrame();
        this.setBounds(110, (frame.getHeight() / 3) + 80, 150, 50);
        this.setBackground(new Color(219, 225, 204));
        this.addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getResultsPanel().resetHsView();
        // db.loadFromDatabase("Roman", hs);
    }
}
