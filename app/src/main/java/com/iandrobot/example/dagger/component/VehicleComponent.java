package com.iandrobot.example.dagger.component;

import com.iandrobot.example.dagger.MainActivity;
import com.iandrobot.example.dagger.model.Vehicle;
import com.iandrobot.example.dagger.module.VehicleModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by surajbhattarai on 10/4/15.
 */

@Singleton
@Component (modules = {VehicleModule.class})
public interface VehicleComponent {
    void inject(MainActivity mainActivity);
}
