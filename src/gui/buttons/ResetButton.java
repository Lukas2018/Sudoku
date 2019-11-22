package gui.buttons;

import game.Game;
import gui.Frame;
import gui.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButton extends JButton implements ActionListener {
    private Frame frame;
    private Game game;

    public ResetButton() {
        super("Reset");
        this.frame = Gui.getGuiInstance().getFrame();
        this.game = Game.getGameInstance();
        this.setBackground(new Color(219, 225, 204));
        this.setBounds(frame.getWidth() - 400, (frame.getHeight() / 4) + 90, 200, 50);
        this.setToolTipText("Clear all values you enter during the game");
        this.addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.reset();
    }
}
