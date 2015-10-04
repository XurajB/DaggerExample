package com.iandrobot.example.dagger.model;

/**
 * Created by surajbhattarai on 10/4/15.
 */
public class AirCondition {
    private boolean status;

    public AirCondition() {
        this.status = false;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }
}
