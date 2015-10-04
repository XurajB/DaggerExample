package com.iandrobot.example.dagger.model;

/**
 * Created by surajbhattarai on 10/4/15.
 */
public class Motor {
    private int rpm;

    public Motor() {
        this.rpm = 0;
    }

    public int getRpm() {
        return rpm;
    }

    public void accelerate(int value) {
        rpm = rpm + value;
    }

    public void brake() {
        rpm = 0;
    }
}
