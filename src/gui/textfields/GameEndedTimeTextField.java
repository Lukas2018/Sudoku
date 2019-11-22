package gui.textfields;

import game.Game;
import gui.Frame;
import gui.Gui;

import javax.swing.*;
import java.awt.*;

public class GameEndedTimeTextField extends JTextField {
    public GameEndedTimeTextField() {
        this.setFont(new Font("Arial", Font.PLAIN, 30));
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setBounds(200, 350, Gui.getGuiInstance().getFrame().getWidth() - 400, 50);
        this.setOpaque(false);
        this.setBorder(null);
        this.setEnabled(false);
        this.setDisabledTextColor(Color.WHITE);
    }
}
