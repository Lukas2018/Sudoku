package game;

public class Score {
    private int result;

    public Score() {
        this.result = 0;
    }

    public int getResult() {
        return result;
    }

    public int calculateResult(String difficulty, String mode, int usedHints, long time) {
        int converter;
        int size;
        int timePoints = Math.round(time / 1000);

        if (difficulty.equals("easy")) {
            converter = 1;
        } else if (difficulty.equals("medium")) {
            converter = 2;
        } else {
            converter = 3;
        }

        if (mode.equals("Hex")) {
            size = 81;
        } else {
            size = 256;
        }
        result = (size - usedHints) * 100 * converter - timePoints * converter;
        return result;
    }
}