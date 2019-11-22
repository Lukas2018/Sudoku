package gui.panels;

import gui.buttons.*;
import gui.labels.BackgroundLabel;
import gui.labels.LogoLabel;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    private LogoLabel logoLabel;
    private BackgroundLabel backgroundLabel;

    private NewGameButton newGameButton;
    private LoadGameButton loadGameButton;
    private HighScoresButton highScoresButton;
    private AboutButton aboutButton;
    private ExitButton exitButton;

    public MenuPanel() {
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
        this.newGameButton = new NewGameButton();
        this.loadGameButton = new LoadGameButton();
        this.highScoresButton = new HighScoresButton();
        this.aboutButton = new AboutButton();
        this.exitButton = new ExitButton();
    }

    private void initLabels() {
        this.logoLabel = new LogoLabel();
        this.backgroundLabel = new BackgroundLabel();
    }

    private void addButtons() {
        this.add(newGameButton);
        this.add(loadGameButton);
        this.add(highScoresButton);
        this.add(aboutButton);
        this.add(exitButton);
    }

    private void addLabels() {
        this.add(logoLabel);
        this.add(backgroundLabel);
    }

    public LogoLabel getLogoLabel() {
        return logoLabel;
    }

    public BackgroundLabel getBackgroundLabel() {
        return backgroundLabel;
    }

    public NewGameButton getNewGameButton() {
        return newGameButton;
    }

    public LoadGameButton getLoadGameButton() {
        return loadGameButton;
    }

    public HighScoresButton getHighScoresButton() {
        return highScoresButton;
    }

    public AboutButton getAboutButton() {
        return aboutButton;
    }

    public ExitButton getExitButton() {
        return exitButton;
    }
}
