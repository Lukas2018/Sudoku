package gui.buttons;

import game.Game;
import gui.Frame;
import gui.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResumeButton extends JButton implements ActionListener {
    private Frame frame;
    private Game game;

    public ResumeButton() {
        super("Resume");
        this.frame = Gui.getGuiInstance().getFrame();
        this.game = Game.getGameInstance();
        this.setBounds((frame.getWidth() / 2) - 150, frame.getHeight() - 300, 300, 100);
        this.setBackground(new Color(219, 225, 204));
        this.addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.startTimer();
        frame.getPausePanel().setVisible(false);
        frame.setContentPane(frame.getPlayPanel());
        frame.getPlayPanel().setVisible(true);
    }
}
