package com.example.motion.myalarm;

public class MyAlarm {
    private final String type;
    private final String time;
    private final String memo;
    private final String againTime;

    public MyAlarm(String type, String time, String memo, String againTime) {
        this.type = type;
        this.time = time;
        this.memo = memo;
        this.againTime = againTime;
    }

    public String getType() {
        return type;
    }

    public String getTime() {
        return time;
    }

    public String getMemo() {
        return memo;
    }

    public String getAgainTime() {
        return againTime;
    }
}

