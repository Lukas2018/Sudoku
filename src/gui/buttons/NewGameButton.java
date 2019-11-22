package gui.buttons;

import gui.Frame;
import gui.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameButton extends JButton implements ActionListener {
    private Frame frame;

    public NewGameButton() {
        super("New Game");
        this.frame = Gui.getGuiInstance().getFrame();
        this.setBackground(new Color(219, 225, 204));
        this.setBounds((frame.getWidth() / 2) - 100, (frame.getHeight() / 2) - 100, 200, 50);
        this.addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getMenuPanel().setVisible(false);
        frame.setContentPane(frame.getModePanel());
        frame.getModePanel().setVisible(true);
    }
}
