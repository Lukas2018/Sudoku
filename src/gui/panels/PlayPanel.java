package gui.panels;

import game.Board;
import game.Game;
import gui.Gui;
import gui.buttons.*;
import gui.labels.BackgroundLabel;
import gui.labels.ClockLabel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.lang.String.valueOf;

public class PlayPanel extends JPanel {
    private CheckButton checkButton;
    private PauseButton pauseButton;
    private HintButton hintButton;
    private ResetButton resetButton;
    private SolutionButton solutionButton;
    private NewSudokuButton newSudokuButton;
    private SaveQuitButton saveQuitButton;
    private QuitButton quitButton;

    private ClockLabel clockLabel;
    private BackgroundLabel backgroundLabel;

    private JTextField[][] jtx;

    public PlayPanel() {
        this.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                new ImageIcon("img/cursor.png").getImage(),
                new Point(0, 0), "custom cursor"));
        this.setLayout(null);
        initComponents();
        addComponents();
    }

    private void initComponents() {
        initButtons();
        initLabels();
    }

    private void addComponents() {
        addButtons();
        addLabels();
    }

    private void initButtons() {
        this.checkButton = new CheckButton();
        this.pauseButton = new PauseButton();
        this.hintButton = new HintButton();
        this.resetButton = new ResetButton();
        this.solutionButton = new SolutionButton();
        this.newSudokuButton = new NewSudokuButton();
        this.saveQuitButton = new SaveQuitButton();
        this.quitButton = new QuitButton();
    }

    private void initLabels() {
        this.clockLabel = new ClockLabel();
        this.backgroundLabel = new BackgroundLabel();
    }

    private void addButtons() {
        this.add(checkButton);
        this.add(pauseButton);
        this.add(hintButton);
        this.add(resetButton);
        this.add(solutionButton);
        this.add(newSudokuButton);
        this.add(saveQuitButton);
        this.add(quitButton);
    }

    private void addLabels() {
        this.add(clockLabel);
        this.add(backgroundLabel);
    }

    public CheckButton getCheckButton() {
        return checkButton;
    }

    public PauseButton getPauseButton() {
        return pauseButton;
    }

    public HintButton getHintButton() {
        return hintButton;
    }

    public ResetButton getResetButton() {
        return resetButton;
    }

    public SolutionButton getSolutionButton() {
        return solutionButton;
    }

    public NewSudokuButton getNewSudokuButton() {
        return newSudokuButton;
    }

    public SaveQuitButton getSaveQuitButton() {
        return saveQuitButton;
    }

    public QuitButton getQuitButton() {
        return quitButton;
    }

    public ClockLabel getClockLabel() {
        return clockLabel;
    }

    public BackgroundLabel getBackgroundLabel() {
        return backgroundLabel;
    }

    public JTextField[][] getJtx() {
        return jtx;
    }

    public void clearField(int row, int column) {
        jtx[row][column].setText("");
        jtx[row][column].setBounds(0, 0, 0, 0);
    }

    public void showSolutionToField(int row, int column, String value) {
        jtx[row][column].setEnabled(false);
        jtx[row][column].setDisabledTextColor(new Color(96, 96, 96));
        jtx[row][column].setText(value);
    }

    public void ifFieldEnabledReset(int row, int column) {
        if (jtx[row][column].isEnabled()) {
            jtx[row][column].setText("");
        }
    }

    public void showCollisionOnBoard(int row, int column, Board board) {
        if(jtx[row][column].getText().equals("")) {
            jtx[row][column].setBackground(Color.white);
            jtx[row][column].setForeground(Color.black);
        } else if (!board.checkRow(row, column, jtx) || !board.checkColumn(row, column, jtx) || !board.checkSquare(row, column, jtx)) {
            if (!jtx[row][column].isEnabled()) {
                jtx[row][column].setDisabledTextColor(Color.white);
                jtx[row][column].setBackground(Color.red);
            } else {
                jtx[row][column].setBackground(new Color(218, 36, 26));
                jtx[row][column].setForeground(Color.white);
            }
        } else if (!jtx[row][column].isEnabled()) {
            jtx[row][column].setBackground(Color.white);
            jtx[row][column].setDisabledTextColor(new Color(96, 96, 96));
        } else {
            jtx[row][column].setBackground(Color.white);
            jtx[row][column].setForeground(Color.black);
        }
    }

    public void complementField(int row, int column, String value) {
        jtx[row][column].setEnabled(false);
        jtx[row][column].setDisabledTextColor(new Color(96, 96, 96));
        jtx[row][column].setText(value);
    }

    public void createBoardView(int size) {
        jtx = new JTextField[size][size];
        Font fontjtx = new Font("Arial", Font.PLAIN, 28);
        Game game = Game.getGameInstance();
        int len;
        if (size == 9) {
            len = (int) (Gui.getGuiInstance().getFrame().getWidth() / 21.5);
        } else {
            len = Gui.getGuiInstance().getFrame().getWidth() / 37;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                jtx[i][j] = new JTextField();
                if ((j <= Math.sqrt(size) - 1) && (i <= Math.sqrt(size) - 1)) {
                    jtx[i][j].setBounds((j + 1) * len + 100, (i + 1) * len, len, len);
                } else if (((j > Math.sqrt(size) - 1) && (j <= 2 * Math.sqrt(size) - 1)) && (i <= Math.sqrt(size) - 1)) {
                    jtx[i][j].setBounds((j + 1) * len + 120, (i + 1) * len, len, len);
                } else if (((j > 2 * Math.sqrt(size) - 1) && (j <= 3 * Math.sqrt(size) - 1)) && (i <= Math.sqrt(size) - 1)) {
                    jtx[i][j].setBounds((j + 1) * len + 140, (i + 1) * len, len, len);
                } else if ((j > 3 * Math.sqrt(size) - 1) && (i <= Math.sqrt(size) - 1)) {
                    jtx[i][j].setBounds((j + 1) * len + 160, (i + 1) * len, len, len);
                } else if ((j <= Math.sqrt(size) - 1) && ((i > Math.sqrt(size) - 1) && (i <= 2 * Math.sqrt(size) - 1))) {
                    jtx[i][j].setBounds((j + 1) * len + 100, (i + 1) * len + 20, len, len);
                } else if (((j > Math.sqrt(size) - 1) && (j <= 2 * Math.sqrt(size) - 1)) && ((i > Math.sqrt(size) - 1) && (i <= 2 * Math.sqrt(size) - 1))) {
                    jtx[i][j].setBounds((j + 1) * len + 120, (i + 1) * len + 20, len, len);
                } else if (((j > 2 * Math.sqrt(size) - 1) && (j <= 3 * Math.sqrt(size) - 1)) && ((i > Math.sqrt(size) - 1) && (i <= 2 * Math.sqrt(size) - 1))) {
                    jtx[i][j].setBounds((j + 1) * len + 140, (i + 1) * len + 20, len, len);
                } else if ((j > 3 * Math.sqrt(size) - 1) && ((i > Math.sqrt(size) - 1) && (i <= 2 * Math.sqrt(size) - 1))) {
                    jtx[i][j].setBounds((j + 1) * len + 160, (i + 1) * len + 20, len, len);
                } else if ((j <= Math.sqrt(size) - 1) && ((i > 2 * Math.sqrt(size) - 1) && (i <= 3 * Math.sqrt(size) - 1))) {
                    jtx[i][j].setBounds((j + 1) * len + 100, (i + 1) * len + 40, len, len);
                } else if (((j > Math.sqrt(size) - 1) && (j <= 2 * Math.sqrt(size) - 1)) && ((i > 2 * Math.sqrt(size) - 1) && (i <= 3 * Math.sqrt(size) - 1))) {
                    jtx[i][j].setBounds((j + 1) * len + 120, (i + 1) * len + 40, len, len);
                } else if (((j > 2 * Math.sqrt(size) - 1) && (j <= 3 * Math.sqrt(size) - 1)) && ((i > 2 * Math.sqrt(size) - 1) && (i <= 3 * Math.sqrt(size) - 1))) {
                    jtx[i][j].setBounds((j + 1) * len + 140, (i + 1) * len + 40, len, len);
                } else if ((j > 3 * Math.sqrt(size) - 1) && ((i > 2 * Math.sqrt(size) - 1) && (i <= 3 * Math.sqrt(size) - 1))) {
                    jtx[i][j].setBounds((j + 1) * len + 160, (i + 1) * len + 40, len, len);
                } else if ((j <= Math.sqrt(size) - 1) && (i > 3 * Math.sqrt(size) - 1)) {
                    jtx[i][j].setBounds((j + 1) * len + 100, (i + 1) * len + 60, len, len);
                } else if (((j > Math.sqrt(size) - 1) && (j <= 2 * Math.sqrt(size) - 1)) && (i > 3 * Math.sqrt(size) - 1)) {
                    jtx[i][j].setBounds((j + 1) * len + 120, (i + 1) * len + 60, len, len);
                } else if (((j > 2 * Math.sqrt(size) - 1) && (j <= 3 * Math.sqrt(size) - 1)) && (i > 3 * Math.sqrt(size) - 1)) {
                    jtx[i][j].setBounds((j + 1) * len + 140, (i + 1) * len + 60, len, len);
                } else if ((j > 3 * Math.sqrt(size) - 1) && (i > 3 * Math.sqrt(size) - 1)) {
                    jtx[i][j].setBounds((j + 1) * len + 160, (i + 1) * len + 60, len, len);
                }
                jtx[i][j].setEnabled(true);
                jtx[i][j].setFont(fontjtx);
                jtx[i][j].setText("");
                jtx[i][j].setBorder(new LineBorder(Color.black, 3));
                jtx[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                final int finalI = i;
                final int finalJ = j;
                jtx[i][j].addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        jtx[finalI][finalJ].setBackground(new Color(129, 166, 221));
                        jtx[finalI][finalJ].setForeground(Color.WHITE);
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        String val = jtx[finalI][finalJ].getText().toUpperCase();
                        jtx[finalI][finalJ].setText(val);
                        game.showCollision();
                    }
                });

                if (game.getMode().equals("Roman")) {
                    jtx[i][j].addKeyListener(new KeyAdapter() {
                        public void keyTyped(KeyEvent e) {
                            if (jtx[finalI][finalJ].getText().length() >= 4)
                                e.consume();
                            String s = "vViIxX";
                            if (!(s.contains(valueOf(e.getKeyChar())))) {
                                e.consume();
                            }
                        }
                    });
                } else if (game.getMode().equals("Hex")) {
                    jtx[i][j].addKeyListener(new KeyAdapter() {
                        public void keyTyped(KeyEvent e) {
                            if (jtx[finalI][finalJ].getText().length() >= 1)
                                e.consume();
                            String s = "0123456789AaBbCcDdEeFf";
                            if (!(s.contains(valueOf(e.getKeyChar()))))
                                e.consume();
                        }
                    });
                } else {
                    jtx[i][j].addKeyListener(new KeyAdapter() {
                        public void keyTyped(KeyEvent e) {
                            if (jtx[finalI][finalJ].getText().length() >= 1)
                                e.consume();
                            String s = "123456789";
                            if (!(s.contains(valueOf(e.getKeyChar()))))
                                e.consume();
                        }
                    });
                }
                this.add(jtx[i][j]);
            }
        }
    }
}
