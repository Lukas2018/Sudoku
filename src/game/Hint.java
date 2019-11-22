package game;

public class Hint {
    private int amountOfHints;

    public Hint(int amountOfHints)
    {
        this.amountOfHints = amountOfHints;
    }
    public Hint() {
        this.amountOfHints = 3;
    }

    public int getAmountOfHints() {
        return amountOfHints;
    }

    public void setAmountOfHints(int amountOfHints) {
        this.amountOfHints = amountOfHints;
    }

    public boolean checkAvailableOfHints() {
        if (amountOfHints > 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getHint() {
        if (!checkAvailableOfHints()) {
            return 0;
        } else {
            decreaseAmountOfHints();
            return getAmountOfHints() + 1;
        }
    }

    public void decreaseAmountOfHints() {
        amountOfHints--;
    }

}