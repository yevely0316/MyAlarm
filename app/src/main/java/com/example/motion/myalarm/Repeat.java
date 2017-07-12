package com.example.motion.myalarm;


/**
 * Created by Motion on 2017-07-10.
 */

public class Repeat {
    private String day;
    private boolean isChecked;

    public Repeat(String day, boolean isChecked) {
        this.day = day;
        this.isChecked = isChecked;
    }

    public String getDay() {
        return day;
    }
    public boolean isChecked() {
        return isChecked;
    }
    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

}
