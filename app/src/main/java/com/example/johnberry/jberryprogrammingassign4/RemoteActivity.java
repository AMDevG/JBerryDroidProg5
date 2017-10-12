package com.example.johnberry.jberryprogrammingassign4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.CompoundButton;
import android.widget.Toast;

import org.w3c.dom.Text;

public class RemoteActivity extends AppCompatActivity
        implements CompoundButton.OnCheckedChangeListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote);

        SeekBar volumeBar = (SeekBar) findViewById(R.id.volumeSlider);
        Switch powerSwitch = (Switch) findViewById(R.id.powerSwitch);
        powerSwitch.setOnCheckedChangeListener(this);
        powerSwitch.setChecked(true);

        final TextView volDisplay = (TextView) findViewById(R.id.volumeDisplay);

        
        volumeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar volumeBar, int i, boolean b) {
                //Log.d(TAG, "onProgressChanged");
                volDisplay.setText("" + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton button, boolean isChecked) {
        TextView powerDisp = (TextView) findViewById(R.id.powerDisplay);
        TextView volDisp = (TextView) findViewById(R.id.volumeDisplay);
        TextView channelDisp = (TextView) findViewById(R.id.currentChannelDisplay);
        SeekBar volumeBar = (SeekBar) findViewById(R.id.volumeSlider);
        TableLayout layout = (TableLayout) findViewById(R.id.tableLayout);
        Button fav1 = (Button) findViewById(R.id.CBS);
        Button fav2 = (Button) findViewById(R.id.CNN);
        Button fav3 = (Button) findViewById(R.id.FX);
        Button channelInc = (Button) findViewById(R.id.chPlus);
        Button channelDecr = (Button) findViewById(R.id.chMinus);

        fav1.setVisibility(View.VISIBLE);
        fav2.setVisibility(View.VISIBLE);
        fav3.setVisibility(View.VISIBLE);
        channelInc.setVisibility(View.VISIBLE);
        channelDecr.setVisibility(View.VISIBLE);
        volumeBar.setVisibility(View.VISIBLE);
        powerDisp.setVisibility(View.VISIBLE);
        volDisp.setVisibility(View.VISIBLE);
        channelDisp.setVisibility(View.VISIBLE);

        if(button.isChecked()){
            powerDisp.setText("On");
            volumeBar.setEnabled(true);
            fav1.setEnabled(true);
            fav2.setEnabled(true);
            fav3.setEnabled(true);
            channelInc.setEnabled(true);
            channelDecr.setEnabled(true);

            for (int i = 0; i <= 9; i++) {
                int id = getResources().getIdentifier("button"+i, "id", getPackageName());
                Button newButt = (Button) findViewById(id);
                newButt.setEnabled(true);
            }
        }
        else{
            powerDisp.setText("Off");
            volDisp.setText("");
            volumeBar.setEnabled(false);
            volumeBar.setProgress(0);
            channelDisp.setText("");

            for (int i = 0; i <= 9; i++) {
                int id = getResources().getIdentifier("button"+i, "id", getPackageName());
                Button newButt = (Button) findViewById(id);
                newButt.setEnabled(false);
            }

            fav1.setEnabled(false);
            fav2.setEnabled(false);
            fav3.setEnabled(false);
            channelInc.setEnabled(false);
            channelDecr.setEnabled(false);
        }
    }




}

