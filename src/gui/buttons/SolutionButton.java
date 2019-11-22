package gui.buttons;

import game.Game;
import gui.Frame;
import gui.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SolutionButton extends JButton implements ActionListener {
    private Frame frame;
    private Game game;

    public SolutionButton() {
        super("Solution");
        this.frame = Gui.getGuiInstance().getFrame();
        this.game = Game.getGameInstance();
        this.setBackground(new Color(219, 225, 204));
        this.setBounds(frame.getWidth() - 400, (frame.getHeight() / 4) + 150, 200, 50);
        this.setToolTipText("Show solution of this sudoku");
        this.addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.showSolution();
        frame.getPlayPanel().getCheckButton().setEnabled(false);
        frame.getPlayPanel().getPauseButton().setEnabled(false);
        frame.getPlayPanel().getHintButton().setEnabled(false);
        frame.getPlayPanel().getResetButton().setEnabled(false);
        frame.getPlayPanel().getSolutionButton().setEnabled(false);
        frame.getPlayPanel().getSaveQuitButton().setEnabled(false);
        game.stopTimer();
    }
}
