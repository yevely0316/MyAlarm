package com.example.motion.myalarm;

/**
 * Created by Motion on 2017-07-12.
 */

public class Replay {
    private String minute;
    private boolean isChecked;

    public Replay(String minute, boolean isChecked) {
        this.minute = minute;
        this.isChecked = isChecked;
    }

    public String getMinute() {
        return minute;
    }
    public boolean isChecked() {
        return isChecked;
    }
    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }
}
