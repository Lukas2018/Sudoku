package gui.buttons;

import game.Game;
import gui.Frame;
import gui.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameEndedQuitButton extends JButton implements ActionListener {
    private Frame frame;
    private Game game;

    public GameEndedQuitButton() {
        super("Main menu");
        this.frame = Gui.getGuiInstance().getFrame();
        this.game = Game.getGameInstance();
        this.setBackground(new Color(219, 225, 204));
        this.setBounds((frame.getWidth() / 2) + 100, 500, 200, 50);
        this.addActionListener(this::actionPerformed);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        game.resetTimer();
        frame.getEndGamePanel().setVisible(false);
        frame.setContentPane(frame.getMenuPanel());
        frame.getMenuPanel().setVisible(true);
    }
}
