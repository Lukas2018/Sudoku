package gui.buttons;

import game.Game;
import gui.Frame;
import gui.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseButton extends JButton implements ActionListener {
    private Frame frame;
    private Game game;

    public PauseButton() {
        super("Pause");
        this.frame = Gui.getGuiInstance().getFrame();
        this.game = Game.getGameInstance();
        this.setBackground(new Color(219, 225, 204));
        this.setBounds(frame.getWidth() - 400, (frame.getHeight() / 4) - 30, 200, 50);
        this.setToolTipText("Pause the game");
        this.addActionListener(this::actionPerformed);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        game.stopTimer();
        frame.getPlayPanel().setVisible(false);
        frame.setContentPane(frame.getPausePanel());
        frame.getPausePanel().setVisible(true);
    }
}
