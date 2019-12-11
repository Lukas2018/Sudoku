package gui.buttons;

import game.Game;
import game.Timer;
import gui.Frame;
import gui.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuitButton extends JButton implements ActionListener {
    private Frame frame;
    private Game game;

    public QuitButton() {
        super("Quit");
        this.frame = Gui.getGuiInstance().getFrame();
        this.game = Game.getGameInstance();
        this.setBounds(frame.getWidth() - 400, (frame.getHeight() / 4) + 450, 200, 50);
        this.setBackground(new Color(228, 47, 27));
        this.setToolTipText("Quit to main menu");
        this.addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?", "End game", dialogButton);
        if (dialogResult == 0) {
            frame.getPlayPanel().setVisible(false);
            frame.getPlayPanel().getCheckButton().setEnabled(true);
            frame.getPlayPanel().getPauseButton().setEnabled(true);
            frame.getPlayPanel().getHintButton().setEnabled(true);
            frame.getPlayPanel().getResetButton().setEnabled(true);
            frame.getPlayPanel().getSolutionButton().setEnabled(true);
            frame.getPlayPanel().getSaveQuitButton().setEnabled(true);
            frame.getPlayPanel().getSolveButton().setEnabled(true);
            frame.setContentPane(frame.getMenuPanel());
            frame.getMenuPanel().setVisible(true);
            frame.getPlayPanel().getSolveButton().stopSwingWorker();
            game.endGame();
        }
    }
}
