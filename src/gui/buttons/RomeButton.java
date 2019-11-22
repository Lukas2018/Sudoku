package gui.buttons;

import game.Game;
import gui.Frame;
import gui.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RomeButton extends JButton implements ActionListener {
    private Frame frame;
    private Game game;

    public RomeButton() {
        super("Sudoku Roman");
        this.frame = Gui.getGuiInstance().getFrame();
        this.game = Game.getGameInstance();
        this.setBackground(new Color(219, 225, 204));
        this.setBounds((frame.getWidth() / 2) - 100, (frame.getHeight() / 2) + 100, 200, 50);
        this.addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getModePanel().setVisible(false);
        frame.setContentPane(frame.getDifficultyPanel());
        frame.getDifficultyPanel().setVisible(true);
        game.setMode("Roman");
    }
}
