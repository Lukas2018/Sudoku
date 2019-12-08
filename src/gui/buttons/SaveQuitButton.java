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

public class SaveQuitButton extends JButton implements ActionListener {
    private Frame frame;
    private Game game;

    public SaveQuitButton() {
        super("Save and quit");
        this.frame = Gui.getGuiInstance().getFrame();
        this.game = Game.getGameInstance();
        this.setBounds(frame.getWidth() - 400, (frame.getHeight() / 4) + 390, 200, 50);
        this.setBackground(new Color(249, 143, 76));
        this.setToolTipText("Save the progress and quit");
        this.addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            game.saveGame(frame.getPlayPanel().getJtx());
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        frame.getPlayPanel().setVisible(false);
        frame.getPlayPanel().getCheckButton().setEnabled(true);
        frame.getPlayPanel().getPauseButton().setEnabled(true);
        frame.getPlayPanel().getHintButton().setEnabled(true);
        frame.getPlayPanel().getResetButton().setEnabled(true);
        frame.getPlayPanel().getSolutionButton().setEnabled(true);
        frame.getPlayPanel().getSaveQuitButton().setEnabled(true);

        frame.setContentPane(frame.getMenuPanel());
        frame.getMenuPanel().setVisible(true);
        game.endGame();
    }
}
