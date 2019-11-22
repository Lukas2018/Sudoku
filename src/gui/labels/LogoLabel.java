package gui.labels;

import gui.Gui;

import javax.swing.*;

public class LogoLabel extends JLabel {
    public LogoLabel() {
        super(new ImageIcon("img/sudoku_logo.png"));
        this.setBounds((Gui.getGuiInstance().getFrame().getWidth() / 2) - 90, 30, 180, 180);
    }
}
