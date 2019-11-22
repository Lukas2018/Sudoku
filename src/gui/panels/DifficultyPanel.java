package gui.panels;

import gui.buttons.EasyButton;
import gui.buttons.HardButton;
import gui.buttons.MediumButton;
import gui.buttons.ReturnDifficultyButton;
import gui.labels.BackgroundLabel;
import gui.labels.LogoLabel;

import javax.swing.*;
import java.awt.*;

public class DifficultyPanel extends JPanel {
    private EasyButton easyButton;
    private MediumButton mediumButton;
    private HardButton hardButton;
    private ReturnDifficultyButton returnDifficultyButton;

    private LogoLabel logoLabel;
    private BackgroundLabel backgroundLabel;

    public DifficultyPanel() {
        this.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                new ImageIcon("img/cursor.png").getImage(),
                new Point(0, 0), "custom cursor"));
        this.setLayout(null);
        initComponents();
        addComponents();
    }

    private void initComponents() {
        initButtons();
        initLabels();
    }

    private void addComponents() {
        addButtons();
        addLabels();
    }

    private void initButtons() {
        this.easyButton = new EasyButton();
        this.mediumButton = new MediumButton();
        this.hardButton = new HardButton();
        this.returnDifficultyButton = new ReturnDifficultyButton();
    }

    private void initLabels() {
        this.logoLabel = new LogoLabel();
        this.backgroundLabel = new BackgroundLabel();
    }

    private void addButtons() {
        this.add(easyButton);
        this.add(mediumButton);
        this.add(hardButton);
        this.add(returnDifficultyButton);
    }

    private void addLabels() {
        this.add(logoLabel);
        this.add(backgroundLabel);
    }
}
