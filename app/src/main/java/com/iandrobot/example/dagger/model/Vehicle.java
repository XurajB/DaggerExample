package com.iandrobot.example.dagger.model;

import javax.inject.Inject;

/**
 * Created by surajbhattarai on 10/4/15.
 */
public class Vehicle {

    private Motor motor;
    private AirCondition ac;

    @Inject
    public Vehicle(Motor motor, AirCondition ac) {
        this.motor = motor;
        this.ac = ac;
    }

    public void increaseSpeed(int value) {
        motor.accelerate(value);
    }

    public void stop() {
        motor.brake();
    }

    public int getSpeed() {
        return motor.getRpm();
    }

    public void openAc() {
        ac.setStatus(true);
    }

    public void closeAc() {
        ac.setStatus(false);
    }

    public boolean isAcOn() {
        return ac.getStatus();
    }
}
