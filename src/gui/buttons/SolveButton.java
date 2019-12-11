package gui.buttons;

import game.Game;
import gui.Frame;
import gui.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SolveButton extends JButton implements ActionListener {
    private Frame frame;
    private Game game;
    private SwingWorker<Void, Void> worker;

    public SolveButton() {
        super("Solve");
        this.frame = Gui.getGuiInstance().getFrame();
        this.game = Game.getGameInstance();
        this.setBackground(new Color(219, 225, 204));
        this.setBounds(frame.getWidth() - 400, (frame.getHeight() / 4) + 210, 200, 50);
        this.setToolTipText("Show solving sudoku process");
        this.addActionListener(this::actionPerformed);
    }

    public void stopSwingWorker() {
        if(worker != null) {
            worker.cancel(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.stopTimer();
        frame.getPlayPanel().getCheckButton().setEnabled(false);
        frame.getPlayPanel().getHintButton().setEnabled(false);
        frame.getPlayPanel().getNewSudokuButton().setEnabled(false);
        frame.getPlayPanel().getPauseButton().setEnabled(false);
        frame.getPlayPanel().getResetButton().setEnabled(false);
        frame.getPlayPanel().getSolveButton().setEnabled(false);
        frame.getPlayPanel().getSolutionButton().setEnabled(false);
        frame.getPlayPanel().getSaveQuitButton().setEnabled(false);
        worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                game.solve();
                return null;
            }

            @Override
            protected void done() {
                frame.getPlayPanel().getNewSudokuButton().setEnabled(true);
            }
        };
        worker.execute();
    }
}
