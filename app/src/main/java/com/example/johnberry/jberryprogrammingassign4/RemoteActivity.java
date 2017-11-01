package com.example.johnberry.jberryprogrammingassign4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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

    private static String TAG;
    public int channelValue = 0;
    public String channelText = "";

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
        Button fav1 = (Button) findViewById(R.id.leftFav);
        Button fav2 = (Button) findViewById(R.id.middleFav);
        Button fav3 = (Button) findViewById(R.id.leftFav);
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

    public void onClick(View v){
        TextView channelDisp = (TextView) findViewById(R.id.currentChannelDisplay);
        channelDisp.setVisibility(View.VISIBLE);

        switch (v.getId()) {
            case  R.id.button0: {
                if(channelText.length()<3){
                    channelText = channelText + "0";
                    channelDisp.setText(channelText);
                }
                else{
                    channelText = "";
                    channelText = channelText + "0";
                    channelDisp.setText(channelText);
                }
                break;
            }
            case R.id.button1: {
                if(channelText.length()<3){
                    channelText = channelText + "1";
                    channelDisp.setText(channelText);
                }
                else{
                    channelText = "";
                    channelText = channelText + "1";
                    channelDisp.setText(channelText);
                }
                break;
            }
            case  R.id.button2: {
                if(channelText.length()<3){
                    channelText = channelText + "2";
                    channelDisp.setText(channelText);
                }
                else{
                    channelText = "";
                    channelText = channelText + "2";
                    channelDisp.setText(channelText);
                }
                break;
            }

            case R.id.button3: {
                if(channelText.length()<3){
                    channelText = channelText + "3";
                    channelDisp.setText(channelText);
                }
                else{
                    channelText = "";
                    channelText = channelText + "3";
                    channelDisp.setText(channelText);
                }
                break;
            }
            case R.id.button4: {
                if(channelText.length()<3){
                    channelText = channelText + "4";
                    channelDisp.setText(channelText);
                }
                else{
                    channelText = "";
                    channelText = channelText + "4";
                    channelDisp.setText(channelText);
                }
                break;
            }

            case R.id.button5: {
                if(channelText.length()<3){
                    channelText = channelText + "5";
                    channelDisp.setText(channelText);
                }
                else{
                    channelText = "";
                    channelText = channelText + "5";
                    channelDisp.setText(channelText);
                }
                break;
            }
            case  R.id.button6: {
                if(channelText.length()<3){
                    channelText = channelText + "6";
                    channelDisp.setText(channelText);
                }
                else{
                    channelText = "";
                    channelText = channelText + "6";
                    channelDisp.setText(channelText);
                }
                break;
            }

            case R.id.button7: {
                if(channelText.length()<3){
                    channelText = channelText + "7";
                    channelDisp.setText(channelText);
                }
                else{
                    channelText = "";
                    channelText = channelText + "7";
                    channelDisp.setText(channelText);
                }
                break;
            }
            case  R.id.button8: {
                if(channelText.length()<3){
                    channelText = channelText + "8";
                    channelDisp.setText(channelText);
                }
                else{
                    channelText = "";
                    channelText = channelText + "8";
                    channelDisp.setText(channelText);
                }
                break;
            }

            case R.id.button9: {
                if(channelText.length()<3){
                    channelText = channelText + "9";
                    channelDisp.setText(channelText);
                }
                else{
                    channelText = "";
                    channelText = channelText + "9";
                    channelDisp.setText(channelText);
                }
                break;
            }
            case  R.id.leftFav: {
                channelText = "";
                channelValue = ConfigurationActivity.getLeftChannel();
                channelDisp.setText(String.valueOf(channelValue));
                break;
            }

            case R.id.middleFav: {
                channelText = "";
                channelValue = ConfigurationActivity.getMiddleChannel();
                channelDisp.setText(String.valueOf(channelValue));
                //channelText = "";

                break;
            }
            case R.id.rightFav: {
                channelText = "";
                channelValue = ConfigurationActivity.getRightChannel();
                channelDisp.setText(String.valueOf(channelValue));
                //channelText = "";

                break;
            }
            case R.id.chMinus: {
                channelValue = Integer.parseInt(String.valueOf(channelDisp.getText()));
                channelValue--;
                if(channelValue<1){
                    channelValue = 1;
                }
                channelDisp.setText(String.valueOf(channelValue));

                break;
            }
            case R.id.chPlus: {
                channelValue = Integer.parseInt(String.valueOf(channelDisp.getText()));
                channelValue++;
               if(channelValue > 999){
                    channelValue = 999;
                }
                channelDisp.setText(String.valueOf(channelValue));

                break;
            }

            case R.id.DVR: {
                Intent nextScreen = new Intent(getApplicationContext(), DVRActivity.class);
                startActivity(nextScreen);
                finish();
            }

            case R.id.configure: {
                Intent configScreen = new Intent(getApplicationContext(), ConfigurationActivity.class);
                startActivity(configScreen);
                finish();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // The activity has become visible (it is now "resumed").
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // The activity is about to be destroyed.
        Log.d(TAG, "onDestory()");
    }
}

