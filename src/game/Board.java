package game;

import gui.Gui;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Board {
    public static int size;
    private Field[][] fields;

    public Board(int size)
    {
        this.size = size;
    }

    public Board(int size, Field[][] fields) {
        this.size = size;
        this.fields = fields;
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size)
    {
        this.size = size;
    }

    private void readBoardFromBase(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String line;
        for (int i = 0; i < size; i++) {
            line = br.readLine();
            String[] p = line.split("\\s+");
            for (int j = 0; j < size; j++) {
                int tmp = Integer.parseInt(p[j]);
                if (p[j].equals("-0")) {
                    fields[i][j].setValueOfField(0);
                    fields[i][j].changeHidden();
                } else {
                    if (tmp >= 0) {
                        fields[i][j].setValueOfField(tmp);
                        fields[i][j].changeEnabled();
                    } else {
                        fields[i][j].setValueOfField(-tmp);
                        fields[i][j].changeHidden();
                    }
                }
            }
        }
    }

    public void switchRows(int row1, int row2) {
        Field[] tmp = new Field[size];
        for (int i = 0; i < size; i++) {
            tmp[i] = new Field();
            tmp[i] = fields[row1][i];
            fields[row1][i] = fields[row2][i];
            fields[row2][i] = tmp[i];
        }
    }

    public void switchCols(int col1, int col2) {
        Field[] tmp = new Field[size];
        for (int i = 0; i < size; i++) {
            tmp[i] = new Field();
            tmp[i] = fields[i][col1];
            fields[i][col1] = fields[i][col2];
            fields[i][col2] = tmp[i];
        }
    }

    public void switchHorizontalBlocks(int block1, int block2) {
        int sizeOfBlock = 0;
        if (size == 9) {
            sizeOfBlock = 3;
        }
        else if (size == 16) {
            sizeOfBlock = 4;
        }
        for (int i = 0; i < sizeOfBlock; i++) {
            switchRows(sizeOfBlock * block1 + i, sizeOfBlock * block2 + i);
        }
    }

    public void switchVerticalBlocks(int block1, int block2) {
        int sizeOfBlock = 0;
        if (size == 9) {
            sizeOfBlock = 3;
        }
        else if (size == 16) {
            sizeOfBlock = 4;
        }
        for (int i = 0; i < sizeOfBlock; i++) {
            switchCols(sizeOfBlock * block1 + i, sizeOfBlock * block2 + i);
        }
    }

    public void makeBoard(String folderPath, String mode, String difficulty) throws IOException {
        Random generator = new Random();
        int sizeOfBlock = 0;
        if (size == 9) {
            sizeOfBlock = 3;
        }
        else if (size == 16) {
            sizeOfBlock = 4;
        }
        int baseSize = 3;
        int basisOfPermutation = 5;
        readBoardFromBase(folderPath + "/" + mode + "_" + difficulty + generator.nextInt(baseSize) + ".txt");
        for (int i = 0; i < basisOfPermutation + generator.nextInt(basisOfPermutation + 1); i++) {
            int block1 = generator.nextInt(sizeOfBlock);
            int block2 = generator.nextInt(sizeOfBlock);
            while (block1 == block2)
                block2 = generator.nextInt(sizeOfBlock);
            switchHorizontalBlocks(block1, block2);
            block1 = generator.nextInt(sizeOfBlock);
            block2 = generator.nextInt(sizeOfBlock);
            while (block1 == block2) {
                block2 = generator.nextInt(sizeOfBlock);
            }
            switchVerticalBlocks(block1, block2);
            block1 = generator.nextInt(sizeOfBlock);
            block2 = generator.nextInt(sizeOfBlock);
            int rowCol1 = generator.nextInt(sizeOfBlock);
            int rowCol2 = generator.nextInt(sizeOfBlock);
            while (rowCol1 == rowCol2) {
                rowCol2 = generator.nextInt(sizeOfBlock);
            }
            switchRows(sizeOfBlock * block1 + rowCol1, sizeOfBlock * block1 + rowCol2);
            rowCol1 = generator.nextInt(sizeOfBlock);
            rowCol2 = generator.nextInt(sizeOfBlock);
            while (rowCol1 == rowCol2) {
                rowCol2 = generator.nextInt(sizeOfBlock);
            }
            switchCols(sizeOfBlock * block2 + rowCol1, sizeOfBlock * block2 + rowCol2);
        }
    }

    public boolean checkRow(int row, int column, JTextField[][] jtx) {
        for (int j = 0; j < size; j++) {
            if (j == column) {
                continue;
            }
            if (jtx[row][column].getText().equals(jtx[row][j].getText())) {
                return false;
            }
        }
        return true;
    }

    public boolean checkColumn(int row, int column, JTextField[][] jtx) {
        for (int i = 0; i < size; i++) {
            if (i == row) {
                continue;
            }
            if (jtx[row][column].getText().equals(jtx[i][column].getText())) {
                return false;
            }
        }
        return true;
    }

    public boolean checkSquare(int row, int column, JTextField[][] jtx) {
        for (int i = 0; i < Math.sqrt(size); i++) {
            for (int j = 0; j < Math.sqrt(size); j++) {
                if ((column <= Math.sqrt(size) - 1) && (row <= Math.sqrt(size) - 1)) {
                    if ((i == row) && (j == column)) {
                        continue;
                    }
                    if (jtx[i][j].getText().equals(jtx[row][column].getText())) {
                        return false;
                    }
                } else if (((column > Math.sqrt(size) - 1) && (column <= 2 * Math.sqrt(size) - 1)) && (row <= Math.sqrt(size) - 1)) {
                    if ((i == row) && (Math.sqrt(size) + j == column)) {
                        continue;
                    }
                    if (jtx[i][(int) (Math.sqrt(size) + j)].getText().equals(jtx[row][column].getText())) {
                        return false;
                    }
                } else if (((column > 2 * Math.sqrt(size) - 1) && (column <= 3 * Math.sqrt(size) - 1)) && (row <= Math.sqrt(size) - 1)) {
                    if ((i == row) && (2 * Math.sqrt(size) + j == column)) {
                        continue;
                    }
                    if (jtx[i][(int) (2 * Math.sqrt(size) + j)].getText().equals(jtx[row][column].getText())) {
                        return false;
                    }
                } else if ((column > 3 * Math.sqrt(size) - 1) && (row <= Math.sqrt(size) - 1)) {
                    if ((i == row) && (3 * Math.sqrt(size) + j == column)) {
                        continue;
                    }
                    if (jtx[i][(int) (3 * Math.sqrt(size) + j)].getText().equals(jtx[row][column].getText())) {
                        return false;
                    }
                } else if ((column <= Math.sqrt(size) - 1) && ((row > Math.sqrt(size) - 1) && (row <= 2 * Math.sqrt(size) - 1))) {
                    if ((Math.sqrt(size) + i == row) && (j == column)) {
                        continue;
                    }
                    if (jtx[(int) (Math.sqrt(size) + i)][j].getText().equals(jtx[row][column].getText())) {
                        return false;
                    }
                } else if (((column > Math.sqrt(size) - 1) && (column <= 2 * Math.sqrt(size) - 1)) && ((row > Math.sqrt(size) - 1) && (row <= 2 * Math.sqrt(size) - 1))) {
                    if ((Math.sqrt(size) + i == row) && (Math.sqrt(size) + j == column)) {
                        continue;
                    }
                    if (jtx[(int) (Math.sqrt(size) + i)][(int) (Math.sqrt(size) + j)].getText().equals(jtx[row][column].getText())) {
                        return false;
                    }
                } else if (((column > 2 * Math.sqrt(size) - 1) && (column <= 3 * Math.sqrt(size) - 1)) && ((row > Math.sqrt(size) - 1) && (row <= 2 * Math.sqrt(size) - 1))) {
                    if ((Math.sqrt(size) + i == row) && (2 * Math.sqrt(size) + j == column)) {
                        continue;
                    }
                    if (jtx[(int) (Math.sqrt(size) + i)][(int) (2 * Math.sqrt(size) + j)].getText().equals(jtx[row][column].getText())) {
                        return false;
                    }
                } else if ((column > 3 * Math.sqrt(size) - 1) && ((row > Math.sqrt(size) - 1) && (row <= 2 * Math.sqrt(size) - 1))) {
                    if ((Math.sqrt(size) + i == row) && (3 * Math.sqrt(size) + j == column)) {
                        continue;
                    }
                    if (jtx[(int) (Math.sqrt(size) + i)][(int) (3 * Math.sqrt(size) + j)].getText().equals(jtx[row][column].getText())) {
                        return false;
                    }
                } else if ((column <= Math.sqrt(size) - 1) && ((row > 2 * Math.sqrt(size) - 1) && (row <= 3 * Math.sqrt(size) - 1))) {
                    if ((2 * Math.sqrt(size) + i == row) && (j == column)) {
                        continue;
                    }
                    if (jtx[(int) (2 * Math.sqrt(size) + i)][j].getText().equals(jtx[row][column].getText())) {
                        return false;
                    }
                } else if (((column > Math.sqrt(size) - 1) && (column <= 2 * Math.sqrt(size) - 1)) && ((row > 2 * Math.sqrt(size) - 1) && (row <= 3 * Math.sqrt(size) - 1))) {
                    if ((2 * Math.sqrt(size) + i == row) && (Math.sqrt(size) + j == column)) {
                        continue;
                    }
                    if (jtx[(int) (2 * Math.sqrt(size) + i)][(int) (Math.sqrt(size) + j)].getText().equals(jtx[row][column].getText())) {
                        return false;
                    }
                } else if (((column > 2 * Math.sqrt(size) - 1) && (column <= 3 * Math.sqrt(size) - 1)) && ((row > 2 * Math.sqrt(size) - 1) && (row <= 3 * Math.sqrt(size) - 1))) {
                    if ((2 * Math.sqrt(size) + i == row) && (2 * Math.sqrt(size) + j == column)) {
                        continue;
                    }
                    if (jtx[(int) (2 * Math.sqrt(size) + i)][(int) (2 * Math.sqrt(size) + j)].getText().equals(jtx[row][column].getText())) {
                        return false;
                    }
                } else if ((column > 3 * Math.sqrt(size) - 1) && ((row > 2 * Math.sqrt(size) - 1) && (row <= 3 * Math.sqrt(size) - 1))) {
                    if ((2 * Math.sqrt(size) + i == row) && (3 * Math.sqrt(size) + j == column)) {
                        continue;
                    }
                    if (jtx[(int) (2 * Math.sqrt(size) + i)][(int) (3 * Math.sqrt(size) + j)].getText().equals(jtx[row][column].getText())) {
                        return false;
                    }
                } else if ((column <= Math.sqrt(size) - 1) && (row > 3 * Math.sqrt(size) - 1)) {
                    if ((3 * Math.sqrt(size) + i == row) && (j == column)) {
                        continue;
                    }
                    if (jtx[(int) (3 * Math.sqrt(size) + i)][j].getText().equals(jtx[row][column].getText())) {
                        return false;
                    }
                } else if (((column > Math.sqrt(size) - 1) && (column <= 2 * Math.sqrt(size) - 1)) && (row > 3 * Math.sqrt(size) - 1)) {
                    if ((3 * Math.sqrt(size) + i == row) && (Math.sqrt(size) + j == column)) {
                        continue;
                    }
                    if (jtx[(int) (3 * Math.sqrt(size) + i)][(int) (Math.sqrt(size) + j)].getText().equals(jtx[row][column].getText())) {
                        return false;
                    }
                } else if (((column > 2 * Math.sqrt(size) - 1) && (column <= 3 * Math.sqrt(size) - 1)) && (row > 3 * Math.sqrt(size) - 1)) {
                    if ((3 * Math.sqrt(size) + i == row) && (2 * Math.sqrt(size) + j == column)) {
                        continue;
                    }
                    if (jtx[(int) (3 * Math.sqrt(size) + i)][(int) (2 * Math.sqrt(size) + j)].getText().equals(jtx[row][column].getText())) {
                        return false;
                    }
                } else if ((column > 3 * Math.sqrt(size) - 1) && (row > 3 * Math.sqrt(size) - 1)) {
                    if ((3 * Math.sqrt(size) + i == row) && (3 * Math.sqrt(size) + j == column)) {
                        continue;
                    }
                    if (jtx[(int) (3 * Math.sqrt(size) + i)][(int) (3 * Math.sqrt(size) + j)].getText().equals(jtx[row][column].getText())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static String convert(int value, String mode) {
        if ((mode.equals("Hex")) || (mode.equals("Standard"))) {
            return Integer.toHexString(value).toUpperCase();
        } else {
            if (value == 1) {
                return "I";
            } else if (value == 2) {
                return "II";
            } else if (value == 3) {
                return "III";
            } else if (value == 4) {
                return "IV";
            } else if (value == 5) {
                return "V";
            } else if (value == 6) {
                return "VI";
            } else if (value == 7) {
                return "VII";
            } else if (value == 8) {
                return "VIII";
            } else if (value == 9) {
                return "IX";
            }
        }
        return "";
    }

    public void complementBoard(String mode) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!fields[i][j].isEnabled()) {
                    Gui.getGuiInstance().getFrame().getPlayPanel().complementField(i, j, convert(fields[i][j].getValueOfField(), mode));
                }
            }
        }
    }

    public boolean checkFields(JTextField[][] jtx, String mode) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!convert(fields[i][j].getValueOfField(), mode).equals(jtx[i][j].getText())) {
                    return false;
                }
            }
        }
        return true;
    }

    public void makeHint(JTextField[][] jtx, String mode) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        int a = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (jtx[i][j].isEnabled()) {
                    if (!convert(fields[i][j].getValueOfField(), mode).equals(jtx[i][j].getText())) {
                        list1.add(i);
                        list2.add(j);
                        a++;
                    }
                }
            }
        }
        if (a != 0) {
            Random r = new Random();
            int rand = r.nextInt(a);
            jtx[list1.get(rand)][list2.get(rand)].setText(convert(fields[list1.get(rand)][list2.get(rand)].getValueOfField(), mode));
            jtx[list1.get(rand)][list2.get(rand)].setEnabled(false);
            jtx[list1.get(rand)][list2.get(rand)].setDisabledTextColor(Color.BLACK);
            jtx[list1.get(rand)][list2.get(rand)].setBackground(Color.lightGray);
        }
    }
}