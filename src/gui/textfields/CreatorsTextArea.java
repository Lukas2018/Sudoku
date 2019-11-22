package gui.textfields;

import gui.Gui;

import javax.swing.*;
import java.awt.*;

public class CreatorsTextArea extends JTextArea {
    public CreatorsTextArea() {
        this.setText("Game made by: \n\n Lukasz Glapiak \n Mateusz Szczepanski \n Bartosz Siwinski \n Maciej Leszczynski");
        this.setFont(new Font("Arial", Font.PLAIN, 32));
        this.setBounds(300, 250, Gui.getGuiInstance().getFrame().getWidth() - 600, Gui.getGuiInstance().getFrame().getHeight() - 400);
        this.setOpaque(false);
        this.setBorder(null);
        this.setEnabled(false);
        this.setDisabledTextColor(Color.WHITE);
    }
}
