package com.iandrobot.example.dagger;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.iandrobot.example.dagger.component.DaggerVehicleComponent;
import com.iandrobot.example.dagger.component.VehicleComponent;
import com.iandrobot.example.dagger.model.Vehicle;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Vehicle vehicle;

    Button upButton;
    Button brakeButton;
    Button acButton;
    TextView speedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        upButton = (Button) findViewById(R.id.up_button);
        brakeButton = (Button) findViewById(R.id.brake_button);
        speedText = (TextView) findViewById(R.id.rpm_text);
        acButton = (Button) findViewById(R.id.ac_button);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        VehicleComponent component = DaggerVehicleComponent.create();
        component.inject(this);

        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vehicle.increaseSpeed(10);
                showSpeed();
            }
        });

        brakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vehicle.stop();
                showSpeed();
            }
        });

        acButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAc(v);
            }
        });

    }

    private void showSpeed() {
        speedText.setText(vehicle.getSpeed() + " mph");
    }

    private void setAc(View view) {

        if (vehicle.isAcOn()) {
            vehicle.closeAc();

        } else {
            vehicle.openAc();
        }

        Snackbar.make(view, "AC is set to " + vehicle.isAcOn(), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
