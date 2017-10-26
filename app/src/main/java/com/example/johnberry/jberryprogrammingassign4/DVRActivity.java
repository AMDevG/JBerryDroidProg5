package com.example.johnberry.jberryprogrammingassign4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TextView;

public class DVRActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    public enum Status {
        ON,
        OFF,
        STOPPED,
        PLAYING,
        PAUSED,
        FAST_FORWARDING,
        FAST_REWINDING,
        RECORDING
    }

    private Status currentDVRStatus;
    private Status currentPower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dvr);

        Switch powerSwitch = (Switch) findViewById(R.id.dvrPowerSwitch);
        TextView powerStatus = (TextView) findViewById(R.id.powerStatus);
        TextView stateStatus = (TextView) findViewById(R.id.stateStatus);

        powerSwitch.setOnCheckedChangeListener(this);
        powerSwitch.setChecked(true);

        powerStatus.setText("On");
        stateStatus.setText("Stopped");

        currentPower = Status.ON;
        currentDVRStatus = Status.STOPPED;
    }
    @Override
    public void onCheckedChanged(CompoundButton button, boolean isChecked) {
        Switch powerSwitch = (Switch) findViewById(R.id.dvrPowerSwitch);
        TextView powerStatus = (TextView) findViewById(R.id.powerStatus);
        TextView stateStatus = (TextView) findViewById(R.id.stateStatus);

        powerSwitch.setVisibility(View.VISIBLE);
        powerStatus.setVisibility(View.VISIBLE);
        stateStatus.setVisibility(View.VISIBLE);

        if (button.isChecked()){
            System.out.println("Power is on");
            currentPower = Status.ON;
            powerStatus.setText("On");
        }
        if(!button.isChecked()){
            System.out.println("Power is off");
            currentPower = Status.OFF;
            currentDVRStatus = Status.STOPPED;
            powerStatus.setText("Off");
        }
    }
}
