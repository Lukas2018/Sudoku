package gui.panels;

import gui.buttons.ReturnAboutButton;
import gui.labels.BackgroundLabel;
import gui.textfields.CreatorsTextArea;

import javax.swing.*;
import java.awt.*;

public class AuthorsPanel extends JPanel {
    private ReturnAboutButton returnAboutButton;

    private CreatorsTextArea creatorsTextArea;

    private BackgroundLabel backgroundLabel;

    public AuthorsPanel() {
        this.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                new ImageIcon("img/cursor.png").getImage(),
                new Point(0, 0), "custom cursor"));
        this.setLayout(null);
        initComponents();
        addComponents();
    }

    private void initComponents() {
        initButton();
        initTextArea();
        initLabel();
    }

    private void addComponents() {
        addButton();
        addTextArea();
        addLabel();
    }

    private void initButton() {
        this.returnAboutButton = new ReturnAboutButton();
    }

    private void initTextArea() {
        this.creatorsTextArea = new CreatorsTextArea();
    }

    private void initLabel() {
        this.backgroundLabel = new BackgroundLabel();
    }

    private void addButton() {
        this.add(returnAboutButton);
    }

    private void addTextArea() {
        this.add(creatorsTextArea);
    }

    private void addLabel() {
        this.add(backgroundLabel);
    }
    public ReturnAboutButton getReturnAboutButton() {
        return returnAboutButton;
    }

    public CreatorsTextArea getCreatorsTextArea() {
        return creatorsTextArea;
    }
}
