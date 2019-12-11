package gui;

import game.Game;
import gui.panels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Frame extends JFrame {
    private AuthorsPanel authorsPanel;
    private DifficultyPanel difficultyPanel;
    private EndGamePanel endGamePanel;
    private MenuPanel menuPanel;
    private ModePanel modePanel;
    private PausePanel pausePanel;
    private PlayPanel playPanel;
    private ResultsPanel resultsPanel;

    public Frame() {
        super("Sudoku");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                String ObjButtons[] = {"Yes", "No"};
                int PromptResult = JOptionPane.showOptionDialog(null,
                        "Are you sure you want to exit?",
                        "Game Exit", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, ObjButtons, ObjButtons[1]);
                if (PromptResult == JOptionPane.YES_OPTION) {
                    dispose();
                    // db.disconnect();
                    Game.getGameInstance().shutDownExecutor();
                }
            }
        });
    }

    public void initPanels() {
        this.authorsPanel = new AuthorsPanel();
        this.difficultyPanel = new DifficultyPanel();
        this.endGamePanel = new EndGamePanel();
        this.menuPanel = new MenuPanel();
        this.modePanel = new ModePanel();
        this.pausePanel = new PausePanel();
        this.playPanel = new PlayPanel();
        this.resultsPanel = new ResultsPanel();
        this.setContentPane(menuPanel);
    }

    public AuthorsPanel getAuthorsPanel() {
        return authorsPanel;
    }

    public DifficultyPanel getDifficultyPanel() {
        return difficultyPanel;
    }

    public EndGamePanel getEndGamePanel() {
        return endGamePanel;
    }

    public MenuPanel getMenuPanel() {
        return menuPanel;
    }

    public ModePanel getModePanel() {
        return modePanel;
    }

    public PausePanel getPausePanel() {
        return pausePanel;
    }

    public PlayPanel getPlayPanel() {
        return playPanel;
    }

    public ResultsPanel getResultsPanel() {
        return resultsPanel;
    }
}
