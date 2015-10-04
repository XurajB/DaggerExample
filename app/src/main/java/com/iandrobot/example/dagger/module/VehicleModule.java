package com.iandrobot.example.dagger.module;

import com.iandrobot.example.dagger.model.AirCondition;
import com.iandrobot.example.dagger.model.Motor;
import com.iandrobot.example.dagger.model.Vehicle;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by surajbhattarai on 10/4/15.
 */

@Module
public class VehicleModule {

    @Provides @Singleton
    Motor provideMotor() {
        return new Motor();
    }

    @Provides @Singleton
    AirCondition provideAC() {
        return new AirCondition();
    }

    @Provides @Singleton
    Vehicle provideVehicle() {
        return new Vehicle(new Motor(), new AirCondition());
    }
}
