package gui.panels;

import gui.buttons.HighScoresHexButton;
import gui.buttons.HighScoresRomanButton;
import gui.buttons.HighScoresStandardButton;
import gui.buttons.ReturnHighScoresButton;
import gui.labels.BackgroundLabel;

import javax.swing.*;
import java.awt.*;

import static java.lang.String.valueOf;

public class ResultsPanel extends JPanel {
    private HighScoresStandardButton highScoresStandardButton;
    private HighScoresHexButton highScoresHexButton;
    private HighScoresRomanButton highScoresRomanButton;
    private ReturnHighScoresButton returnHighScoresButton;

    private BackgroundLabel backgroundLabel;

    private JTextField[][] hs;

    public ResultsPanel() {
        this.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                new ImageIcon("img/cursor.png").getImage(),
                new Point(0, 0), "custom cursor"));
        this.setLayout(null);
        initComponents();
        addComponents();
        createScoreView();
    }

    private void initComponents() {
        initButtons();
        initLabel();
    }

    private void addComponents() {
        addButtons();
        addLabel();
    }

    private void initButtons() {
        this.highScoresStandardButton = new HighScoresStandardButton();
        this.highScoresHexButton = new HighScoresHexButton();
        this.highScoresRomanButton = new HighScoresRomanButton();
        this.returnHighScoresButton = new ReturnHighScoresButton();
    }

    private void initLabel() {
        this.backgroundLabel = new BackgroundLabel();
    }

    private void addButtons() {
        this.add(highScoresStandardButton);
        this.add(highScoresHexButton);
        this.add(highScoresRomanButton);
        this.add(returnHighScoresButton);
    }

    private void addLabel() {
        this.add(backgroundLabel);
    }

    private void createScoreView() {
        hs = new JTextField[11][4];
        int len;
        int high = 55;
        for (int i = 0; i < 11; i++) {
            len = 250;
            for (int j = 0; j < 4; j++) {
                hs[i][j] = new JTextField();
                hs[i][j].setBounds(len, high, 250, 55);
                hs[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                hs[i][j].setBorder(null);
                hs[i][j].setOpaque(false);
                hs[i][j].setEnabled(false);
                hs[i][j].setDisabledTextColor(Color.WHITE);
                if (i == 0) {
                    hs[i][j].setFont(new Font("Arial", Font.PLAIN, 20));
                } else {
                    hs[i][j].setFont(new Font("Arial", Font.PLAIN, 15));
                }

                if ((j == 0) && (i >= 1)) {
                    hs[i][j].setText(valueOf(i));
                }
                this.add(hs[i][j]);
                len = len + 250;
            }
            high = high + 55;
        }

        hs[0][0].setText("Nr");
        hs[0][1].setText("Mode");
        hs[0][2].setText("Difficulty");
        hs[0][3].setText("Score");
    }

    public void resetHsView() {
        for (int i = 1; i < 11; i++) {
            hs[i][1].setText("");
            hs[i][2].setText("");
            hs[i][3].setText("");
        }
    }
}
