package gui.buttons;

import gui.Frame;
import gui.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnModeButton extends JButton implements ActionListener {
    private Frame frame;

    public ReturnModeButton() {
        super("Return");
        this.frame = Gui.getGuiInstance().getFrame();
        this.setBounds(100, frame.getHeight() - 200, 200, 50);
        this.setBackground(new Color(228, 47, 27));
        this.addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getModePanel().setVisible(false);
        frame.setContentPane(frame.getMenuPanel());
        frame.getMenuPanel().setVisible(true);
    }
}
