package gui.buttons;

import game.Game;
import game.Timer;
import gui.Frame;
import gui.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GameEndedNewSudokuButton extends JButton implements ActionListener {
    private Frame frame;
    private  Game game;

    public GameEndedNewSudokuButton() {
        super("New Sudoku");
        this.frame = Gui.getGuiInstance().getFrame();
        this.game = Game.getGameInstance();
        this.setBackground(new Color(219, 225, 204));
        this.setBounds((frame.getWidth() / 2) - 300, 500, 200, 50);
        this.addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.resetTimer();
        frame.getPlayPanel().getCheckButton().setEnabled(true);
        frame.getPlayPanel().getPauseButton().setEnabled(true);
        frame.getPlayPanel().getHintButton().setEnabled(true);
        frame.getPlayPanel().getResetButton().setEnabled(true);
        frame.getPlayPanel().getSolutionButton().setEnabled(true);
        frame.getPlayPanel().getNewSudokuButton().setEnabled(true);
        frame.getPlayPanel().getSaveQuitButton().setEnabled(true);
        frame.getPlayPanel().getSolveButton().setEnabled(true);
        if (game.getMode().equals("Hex")) {
            frame.getPlayPanel().createBoardView(16);
        } else {
            frame.getPlayPanel().createBoardView(9);
        }
        try {
            game.start();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        frame.getEndGamePanel().setVisible(false);
        frame.setContentPane(frame.getPlayPanel());
        frame.getPlayPanel().setVisible(true);
    }
}
