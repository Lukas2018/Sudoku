package gui.buttons;

import database.Database;
import game.Game;
import gui.Frame;
import gui.Gui;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckButton extends JButton implements ActionListener {
    private Frame frame;
    private Game game;
    private Database database;

    public CheckButton() {
        super("Check");
        this.frame = Gui.getGuiInstance().getFrame();
        this.game = Game.getGameInstance();
        this.database = Database.getDatabaseInstance();
        this.setBackground(new Color(120, 195, 101));
        this.setBounds(frame.getWidth() - 400, (frame.getHeight() / 4) + 330, 200, 50);
        this.setToolTipText("Click to check your solving");
        this.addActionListener(this::actionPerformed);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (game.checkIsGameEnded()) {
            frame.getEndGamePanel().getGameEndedScoreTextField().setText("Your Score: " + String.valueOf(game.getScore()));
            frame.getEndGamePanel().getGameEndedTimeTextField().setText("Your Time: " + game.getTimerTime());
            frame.getPlayPanel().setVisible(false);
            frame.setContentPane(frame.getEndGamePanel());
            frame.getEndGamePanel().setVisible(true);
            // database.check
            if (Database.getDatabaseInstance().isInTop(game.getMode(), game.getScore())) {
                Database.getDatabaseInstance().saveToDatabase(game.getMode(), game.getDifficulty(), game.getScore());
            }
        } else {
            game.showCollision();
        }
    }
}
