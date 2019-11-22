package gui.panels;

import gui.buttons.ResumeButton;
import gui.labels.BackgroundLabel;
import gui.textfields.GamePausedTextFIeld;

import javax.swing.*;
import java.awt.*;

public class PausePanel extends JPanel {
    private ResumeButton resumeButton;

    private GamePausedTextFIeld gamePausedTextFIeld;

    private BackgroundLabel backgroundLabel;

    public PausePanel() {
        this.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                new ImageIcon("img/cursor.png").getImage(),
                new Point(0, 0), "custom cursor"));
        this.setLayout(null);
        initComponents();
        addComponents();
    }

    private void initComponents() {
        initButton();
        initTextField();
        initLabel();
    }

    private void addComponents() {
        addButton();
        addTextField();
        addLabel();
    }

    private void initButton() {
        this.resumeButton = new ResumeButton();
    }

    private void initTextField() {
        this.gamePausedTextFIeld = new GamePausedTextFIeld();
    }

    private void initLabel() {
        this.backgroundLabel = new BackgroundLabel();
    }

    private void addButton() {
        this.add(resumeButton);
    }

    private void addTextField() {
        this.add(gamePausedTextFIeld);
    }

    private void addLabel() {
        this.add(backgroundLabel);
    }
}
