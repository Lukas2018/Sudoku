package gui.labels;

import gui.Gui;

import javax.swing.*;
import java.awt.*;

public class ClockLabel extends JLabel {
    public ClockLabel() {
        super("00:00:00");
        this.setFont(new Font("Arial", Font.PLAIN, 32));
        this.setForeground(Color.white);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setBounds(Gui.getGuiInstance().getFrame().getWidth() - 400, (Gui.getGuiInstance().getFrame().getHeight() / 4) - 120, 200, 50);
    }
}
