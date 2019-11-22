package game;

public class Timer {

    private long startTime;
    private long stopTime;
    private boolean isRunning;

    public Timer() {
        this.isRunning = false;
        this.stopTime = 0;
    }

    public void setTimer(long savedTime) {
        isRunning = false;
        stopTime = savedTime;
    }

    public void startTimer() {
        isRunning = true;
        startTime = System.currentTimeMillis();
    }

    public void stopTimer() {
        isRunning = false;
        stopTime += System.currentTimeMillis() - startTime;
    }

    public void resetTimer() {
        stopTime = 0;
        startTime = 0;
    }

    public long getTime() {
        if (isRunning)
            return stopTime + System.currentTimeMillis() - startTime;
        else
            return stopTime;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public String displayableTime() {
        long time = Math.round(getTime() / 1000);
        int secs = (int) time % 60;
        int mins = (int) ((time - secs) / 60) % 60;
        int hours = (int) (time - mins * 60) / 60;
        return String.format("%02d:%02d:%02d", hours, mins, secs);
    }

}