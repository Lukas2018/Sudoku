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

public class NewSudokuButton extends JButton implements ActionListener {
    private Frame frame;
    private Game game;

    public NewSudokuButton() {
        super("New sudoku");
        this.frame = Gui.getGuiInstance().getFrame();
        this.game = Game.getGameInstance();
        this.setBounds(frame.getWidth() - 400, (frame.getHeight() / 4) + 270, 200, 50);
        this.setBackground(new Color(219, 225, 204));
        this.setToolTipText("Generate new Sudoku instead of this one");
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
        frame.getPlayPanel().getNewSudokuButton().setEnabled(false);
        frame.getPlayPanel().getSolveButton().setEnabled(true);
        frame.getPlayPanel().getSaveQuitButton().setEnabled(true);
        game.clearBoard();
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
        frame.getPlayPanel().getNewSudokuButton().setEnabled(true);
    }
}
