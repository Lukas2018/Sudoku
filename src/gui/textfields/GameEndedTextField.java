package gui.textfields;

import gui.Gui;

import javax.swing.*;
import java.awt.*;

public class GameEndedTextField extends JTextField {
    public GameEndedTextField() {
        super("Congratulations! You did well!");
        this.setFont(new Font("Arial", Font.PLAIN, 40));
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setBounds(200, 200, Gui.getGuiInstance().getFrame().getWidth() - 400, 100);
        this.setOpaque(false);
        this.setBorder(null);
        this.setEnabled(false);
        this.setDisabledTextColor(Color.WHITE);
    }
}
