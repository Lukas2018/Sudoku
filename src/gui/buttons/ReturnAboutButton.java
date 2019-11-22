package gui.buttons;

import gui.Frame;
import gui.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnAboutButton extends JButton implements ActionListener {
    private Frame frame;

    public ReturnAboutButton() {
        super("Return");
        this.frame = Gui.getGuiInstance().getFrame();
        this.setBackground(new Color(228, 47, 27));
        this.setBounds(100, frame.getHeight() - 200, 200, 50);
        this.addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getAuthorsPanel().setVisible(false);
        frame.setContentPane(frame.getMenuPanel());
        frame.getMenuPanel().setVisible(true);
    }
}
