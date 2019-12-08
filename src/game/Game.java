package game;

import gui.Gui;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Game {
    private String difficulty;
    private String mode;
    private Board board;
    private Hint hint;
    private Score score;
    private Field[][] fields;
    private static Game game;
    private Timer timer;
    private Gui gui;
    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    public static Game getGameInstance() {
        if(game == null) {
            game = new Game();
        }
        return game;
    }

    private Game() {
        this.timer = new Timer();
        this.gui = Gui.getGuiInstance();
        this.hint = new Hint();
        this.score = new Score();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Gui gui = Gui.getGuiInstance();
            gui.createComponents();
        });
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void start() throws IOException {
        if (mode.equals("Hex")) {
            fields = new Field[16][16];
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++) {
                    fields[i][j] = new Field();
                }
            }
            board = new Board(16, fields);
        } else {
            fields = new Field[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    fields[i][j] = new Field();
                }
            }
            board = new Board(9, fields);
        }
        board.makeBoard("plansze", mode, difficulty);
        board.complementBoard(mode);
        startTimer();
        clockRun();
    }

    public void startTimer() {
        timer.startTimer();
    }

    public void stopTimer() {
        timer.stopTimer();
    }

    public void resetTimer() {
        stopTimer();
        timer.resetTimer();
    }

    public void loadTimer() throws IOException {
        timer.setTimer(game.loadGame(gui.getFrame().getPlayPanel().getJtx()));
        startTimer();
    }

    public String getTimerTime() {
        return timer.displayableTime();
    }

    public boolean checkIsGameEnded() {
        if(getBoard().checkFields(gui.getFrame().getPlayPanel().getJtx(), getMode())){
            endGame();
            return true;
        }
        return false;
    }

    public void endGame() {
        clearBoard();
        resetTimer();
        score.calculateResult(difficulty, mode, 3 - hint.getAmountOfHints(), timer.getTime());
    }

    public void clockRun() {
        Runnable helloRunnable = () -> gui.getFrame().getPlayPanel().getClockLabel().setText(timer.displayableTime());
        executor.scheduleAtFixedRate(helloRunnable, 0, 3, TimeUnit.MILLISECONDS);
    }

    public void shutDownExecutor() {
        executor.shutdown();
    }

    public void makeHint() {
        if (hint.getHint() == 0) {
            board.makeHint(gui.getFrame().getPlayPanel().getJtx(), mode);
            gui.getFrame().getPlayPanel().getHintButton().setEnabled(false);
        } else {
            board.makeHint(gui.getFrame().getPlayPanel().getJtx(), mode);
            hint.getHint();
        }
    }

    public void showCollision() {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                gui.getFrame().getPlayPanel().showCollisionOnBoard(i, j, board);
            }
        }
    }

    public Board getBoard() {
        return board;
    }

    public Hint getHint() {
        return hint;
    }

    public Score getScore() {
        return score;
    }

    public void showSolution() {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                gui.getFrame().getPlayPanel().showSolutionToField(i, j, board.convert(fields[i][j].getValueOfField(), mode));
            }
        }
    }

    public boolean solve() {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                // we search an empty cell
                if (gui.getFrame().getPlayPanel().getFieldValue(i, j) == -1) {
                    for (int number = 1; number <= board.getSize(); number++) {
                        if (isOk(i, j, number)) {
                            gui.getFrame().getPlayPanel().setFieldValue(i, j, String.valueOf(number));
                            if (solve()) {
                                return true;
                            } else {
                                gui.getFrame().getPlayPanel().setFieldValue(i, j, "");
                            }
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    private boolean isInRow(int row, int number) {
        for (int i = 0; i < board.getSize(); i++)
            if (gui.getFrame().getPlayPanel().getFieldValue(row, i) == number)
                return true;

        return false;
    }

    private boolean isInCol(int col, int number) {
        for (int i = 0; i < board.getSize(); i++)
            if (gui.getFrame().getPlayPanel().getFieldValue(i, col) == number)
                return true;

        return false;
    }

    private boolean isInBox(int row, int col, int number) {
        int r = (int) (row - row % Math.sqrt(board.getSize()));
        int c = (int) (col - col % Math.sqrt(board.getSize()));

        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (gui.getFrame().getPlayPanel().getFieldValue(i, j) == number)
                    return true;

        return false;
    }

    private boolean isOk(int row, int col, int number) {
        return !isInRow(row, number)  &&  !isInCol(col, number)  &&  !isInBox(row, col, number);
    }

    public void reset() {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                gui.getFrame().getPlayPanel().ifFieldEnabledReset(i, j);
            }
        }
    }

    public void clearBoard() {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                gui.getFrame().getPlayPanel().clearField(i, j);
            }
        }
        hint.setAmountOfHints(3);
    }

    public void saveGame(JTextField[][] jtx) throws IOException {
        FileWriter fileWriter = new FileWriter("plansze/save.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(mode);
        printWriter.println(difficulty);
        printWriter.println(String.valueOf(timer.getTime()));
        printWriter.println(hint.getAmountOfHints());
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (!jtx[i][j].getText().equals("")) {
                    if (!jtx[i][j].isEnabled()) {
                        printWriter.printf("-%s ", jtx[i][j].getText());
                    } else {
                        printWriter.printf("%s ", jtx[i][j].getText());
                    }
                } else
                    printWriter.printf("99 ");
            }
            printWriter.println();
        }
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                printWriter.printf("%s ", fields[i][j].getValueOfField());
            }
            printWriter.println();
        }
        printWriter.close();
    }

    public void startLoad() {
        if (mode.equals("Hex")) {
            fields = new Field[16][16];
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++) {
                    fields[i][j] = new Field();
                }
            }
            board = new Board(16, fields);
        } else {
            fields = new Field[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    fields[i][j] = new Field();
                }
            }
            board = new Board(9, fields);
        }
    }

    public long loadGame(JTextField[][] jtx) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("plansze/save.txt")));
        int size;
        String line;
        String mode = br.readLine();
        if (mode.equals("Hex")) {
            size = 16;
        } else {
            size = 9;
        }
        br.readLine();
        line = br.readLine();
        long time = Long.valueOf(line);
        br.readLine();
        if (mode.equals("Roman")) {
            for (int i = 0; i < size; i++) {
                line = br.readLine();
                String[] p = line.split("\\s+");
                for (int j = 0; j < size; j++) {
                    if ((p[j].charAt(0)) == '-') {
                        jtx[i][j].setText(p[j].substring(1, p[j].length()));
                        jtx[i][j].setEnabled(false);
                        jtx[i][j].setDisabledTextColor(new Color(96, 96, 96));
                    } else if (p[j].equals("99")) {
                        jtx[i][j].setText("");
                    } else {
                        jtx[i][j].setText(p[j]);
                        jtx[i][j].setForeground(Color.black);
                    }
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                line = br.readLine();
                String[] p = line.split("\\s+");
                for (int j = 0; j < size; j++) {
                    int tmp = Integer.parseInt(p[j], 16);
                    if (p[j].equals("-0")) {
                        jtx[i][j].setText("0");
                        jtx[i][j].setEnabled(false);
                        jtx[i][j].setDisabledTextColor(new Color(96, 96, 96));
                    } else if (p[j].equals("99")) {
                        jtx[i][j].setText("");
                    } else {
                        if (tmp >= 0) {
                            jtx[i][j].setText(Integer.toString(tmp, 16).toUpperCase());
                            jtx[i][j].setForeground(Color.black);

                        } else {
                            jtx[i][j].setText(Integer.toString(-tmp, 16).toUpperCase());
                            jtx[i][j].setEnabled(false);
                            jtx[i][j].setDisabledTextColor(new Color(96, 96, 96));
                        }
                    }
                }
            }
        }
        for (int i = 0; i < size; i++) {
            line = br.readLine();
            String[] p = line.split("\\s+");
            for (int j = 0; j < size; j++) {
                fields[i][j].setValueOfField(Integer.parseInt(p[j]));
            }
        }
        br.close();
        return time;
    }
}
