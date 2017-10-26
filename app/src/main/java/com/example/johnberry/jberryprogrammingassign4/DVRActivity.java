package com.example.johnberry.jberryprogrammingassign4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TextView;

import static com.example.johnberry.jberryprogrammingassign4.R.id.fastForward;
import static com.example.johnberry.jberryprogrammingassign4.R.id.stateStatus;

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
    private Switch powerSwich;
    private TextView stateStatus;

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

        Button playButton = (Button) findViewById(R.id.playButton);
        Button stopButton = (Button) findViewById(R.id.stopButton);
        Button pauseButton = (Button) findViewById(R.id.pauseButton);
        Button forwardButton = (Button) findViewById(R.id.fastForward);
        Button rewindButton = (Button) findViewById(R.id.fastRewind);
        Button recordButton = (Button) findViewById(R.id.recordButton);

        powerSwitch.setVisibility(View.VISIBLE);
        powerStatus.setVisibility(View.VISIBLE);
        stateStatus.setVisibility(View.VISIBLE);

        if (button.isChecked()){
            System.out.println("Power is on");
            currentPower = Status.ON;

            powerStatus.setText("On");
            stateStatus.setText("Stopped");

            playButton.setEnabled(true);
            stopButton.setEnabled(true);
            pauseButton.setEnabled(true);
            forwardButton.setEnabled(true);
            rewindButton.setEnabled(true);
            recordButton.setEnabled(true);

        }
        if(!button.isChecked()){
            System.out.println("Power is off");
            currentPower = Status.OFF;
            currentDVRStatus = Status.STOPPED;
            stateStatus.setText("Off");
            powerStatus.setText("Off");

            playButton.setEnabled(false);
            stopButton.setEnabled(false);
            pauseButton.setEnabled(false);
            forwardButton.setEnabled(false);
            rewindButton.setEnabled(false);
            recordButton.setEnabled(false);
        }
    }

    public void onClick(View v) {

        //powerStatus.setVisibility(View.VISIBLE);
        TextView stateStatus = (TextView) findViewById(R.id.stateStatus);
        stateStatus.setVisibility(View.VISIBLE);

        switch (v.getId()) {
            case R.id.fastForward: {
                if(currentDVRStatus.equals(Status.PLAYING)){
                    currentDVRStatus = Status.FAST_FORWARDING;
                    stateStatus.setText("Forwarding");
                }
                else{
                    System.out.println("Sorry the system is not playing. cannot forward");
                }
                break;
            }
            case R.id.fastRewind: {
                if(currentDVRStatus.equals(Status.PLAYING)){
                    currentDVRStatus = Status.FAST_REWINDING;
                    stateStatus.setText("Rewinding");
                }
                else{
                    System.out.println("Sorry the system is not playing. cannot rewind");
                }

                break;
            }
            case R.id.playButton: {
                if(!currentDVRStatus.equals(Status.RECORDING)) {
                    currentDVRStatus = Status.PLAYING;
                    stateStatus.setText("Playing");
                }
                break;
            }
            case R.id.stopButton: {
                currentDVRStatus = Status.STOPPED;
                stateStatus.setText("Stopped");
                break;
            }
            case R.id.pauseButton: {
                if(currentDVRStatus.equals(Status.PLAYING)){
                    currentDVRStatus = Status.PAUSED;
                    stateStatus.setText("Paused");
                }
                else{
                    System.out.println("Sorry the system is not playing. cannot pause");
                }

                break;
            }
            case R.id.recordButton: {
                if(!currentDVRStatus.equals(Status.STOPPED)) {
                    System.out.println("System not stopped cannot record!");
                }
                else{
                    currentDVRStatus = Status.RECORDING;
                    stateStatus.setText("Recording");
                }
                break;
            }
            case R.id.switchTV: {
                currentDVRStatus = Status.STOPPED;
                stateStatus.setText("Stopped");

                Intent remoteScreen = new Intent(getApplicationContext(), RemoteActivity.class);
                startActivity(remoteScreen);
                }
                break;
            }
        }
    }
