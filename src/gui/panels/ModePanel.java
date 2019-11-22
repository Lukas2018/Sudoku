package gui.panels;

import gui.buttons.HexButton;
import gui.buttons.ReturnModeButton;
import gui.buttons.RomeButton;
import gui.buttons.StandardButton;
import gui.labels.BackgroundLabel;
import gui.labels.LogoLabel;

import javax.swing.*;
import java.awt.*;

public class ModePanel extends JPanel {
    private StandardButton standardButton;
    private HexButton hexButton;
    private RomeButton romeButton;
    private ReturnModeButton returnModeButton;

    private LogoLabel logoLabel;
    private BackgroundLabel backgroundLabel;

    public ModePanel() {
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
        this.standardButton = new StandardButton();
        this.hexButton = new HexButton();
        this.romeButton = new RomeButton();
        this.returnModeButton = new ReturnModeButton();
    }

    private void initLabels() {
        this.logoLabel = new LogoLabel();
        this.backgroundLabel = new BackgroundLabel();
    }

    private void addButtons() {
        this.add(standardButton);
        this.add(hexButton);
        this.add(romeButton);
        this.add(returnModeButton);
    }

    private void addLabels() {
        this.add(logoLabel);
        this.add(backgroundLabel);
    }
}
