package game;

public class Field {
    private int value;
    private boolean hidden;
    private boolean enabled;

    public Field() {
        this.value = 0;
        this.hidden = false;
        this.enabled = true;
    }

    public int getValueOfField() {
        return value;
    }

    public void setValueOfField(int value) {
        this.value = value;
    }

    public void changeHidden() {
        hidden = !hidden;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void changeEnabled() {
        enabled = !enabled;
    }
}
