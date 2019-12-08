package gui.buttons;

import game.Game;
import gui.Frame;
import gui.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class LoadGameButton extends JButton implements ActionListener {
    private Frame frame;
    private Game game;

    public LoadGameButton() {
        super("Load Game");
        this.frame = Gui.getGuiInstance().getFrame();
        this.game = Game.getGameInstance();
        this.setBackground(new Color(219, 225, 204));
        this.setBounds((frame.getWidth() / 2) - 100, (frame.getHeight() / 2 - 30), 200, 50);
        this.addActionListener(this::actionPerformed);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("plansze/save.txt")));
            String line = br.readLine();
            game.setMode(line);
            game.clearBoard();
            if (line.equals("Hex"))
                frame.getPlayPanel().createBoardView(16);
            else
                frame.getPlayPanel().createBoardView(9);
            line = br.readLine();
            game.setDifficulty(line);
            br.readLine();
            line = br.readLine();
            br.close();
            game.startLoad();
            game.getHint().setAmountOfHints(Integer.parseInt(line));
            if (game.getHint().getAmountOfHints() == 0)
                frame.getPlayPanel().getHintButton().setEnabled(false);
            game.loadTimer();
            frame.setContentPane(frame.getPlayPanel());
            frame.getPlayPanel().add(frame.getPlayPanel().getBackgroundLabel());
            frame.getPlayPanel().setVisible(true);
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
