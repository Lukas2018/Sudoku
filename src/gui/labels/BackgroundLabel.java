package gui.labels;

import gui.Gui;

import javax.swing.*;

public class BackgroundLabel extends JLabel {
    public BackgroundLabel() {
        super(new ImageIcon("img/tlo.jpg"));
        this.setBounds(0, 0, Gui.getGuiInstance().getFrame().getWidth(), Gui.getGuiInstance().getFrame().getHeight());
    }
}
