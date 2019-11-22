package gui.panels;

import gui.buttons.GameEndedNewSudokuButton;
import gui.buttons.GameEndedQuitButton;
import gui.labels.BackgroundLabel;
import gui.textfields.GameEndedScoreTextField;
import gui.textfields.GameEndedTextField;
import gui.textfields.GameEndedTimeTextField;

import javax.swing.*;
import java.awt.*;

public class EndGamePanel extends JPanel {
    private GameEndedNewSudokuButton gameEndedNewSudokuButton;
    private GameEndedQuitButton gameEndedQuitButton;
    private GameEndedTextField gameEndedTextField;
    private GameEndedScoreTextField gameEndedScoreTextField;
    private GameEndedTimeTextField gameEndedTimeTextField;

    private BackgroundLabel backgroundLabel;

    public EndGamePanel() {
        this.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                new ImageIcon("img/cursor.png").getImage(),
                new Point(0, 0), "custom cursor"));
        this.setLayout(null);
        initComponents();
        addComponents();
    }

    private void initComponents() {
        initButtons();
        initTextFields();
        initLabel();
    }

    private void addComponents() {
        addButtons();
        addTextFields();
        addLabel();
    }

    private void initButtons() {
        this.gameEndedNewSudokuButton = new GameEndedNewSudokuButton();
        this.gameEndedQuitButton = new GameEndedQuitButton();
    }

    private void initTextFields() {
        this.gameEndedTextField = new GameEndedTextField();
        this.gameEndedScoreTextField = new GameEndedScoreTextField();
        this.gameEndedTimeTextField = new GameEndedTimeTextField();
    }

    private void initLabel() {
        this.backgroundLabel = new BackgroundLabel();
    }

    private void addButtons() {
        this.add(gameEndedNewSudokuButton);
        this.add(gameEndedQuitButton);
    }

    private void addTextFields() {
        this.add(gameEndedTextField);
        this.add(gameEndedScoreTextField);
        this.add(gameEndedTimeTextField);
    }

    private void addLabel() {
        this.add(backgroundLabel);
    }

    public GameEndedNewSudokuButton getGameEndedNewSudokuButton() {
        return gameEndedNewSudokuButton;
    }

    public GameEndedQuitButton getGameEndedQuitButton() {
        return gameEndedQuitButton;
    }

    public GameEndedTextField getGameEndedTextField() {
        return gameEndedTextField;
    }

    public GameEndedScoreTextField getGameEndedScoreTextField() {
        return gameEndedScoreTextField;
    }

    public GameEndedTimeTextField getGameEndedTimeTextField() {
        return gameEndedTimeTextField;
    }

    public BackgroundLabel getBackgroundLabel() {
        return backgroundLabel;
    }
}
