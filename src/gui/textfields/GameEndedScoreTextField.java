package gui.textfields;

import gui.Gui;

import javax.swing.*;
import java.awt.*;

public class GameEndedScoreTextField extends JTextField {
    public GameEndedScoreTextField() {
        this.setFont(new Font("Arial", Font.PLAIN, 30));
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setBounds(200, 300, Gui.getGuiInstance().getFrame().getWidth() - 400, 50);
        this.setOpaque(false);
        this.setBorder(null);
        this.setEnabled(false);
        this.setDisabledTextColor(Color.WHITE);
    }
}
