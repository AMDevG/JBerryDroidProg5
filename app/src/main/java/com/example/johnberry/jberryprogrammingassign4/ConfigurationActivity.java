package com.example.johnberry.jberryprogrammingassign4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ConfigurationActivity extends AppCompatActivity {

    private String channelText = "";
    private int channelValue = 0;

    public static int leftSavedChannel = 0;
    public static int middleSavedChannel = 0;
    public static int rightSavedChannel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
    }


    public void onClick(View v) {
        EditText channelDisp = (EditText) findViewById(R.id.channelText);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.RGroup);
        Button saveButton = (Button) findViewById(R.id.saveButton);
        RadioButton rightButton = (RadioButton) findViewById(R.id.rightRadio);
        RadioButton middleButton = (RadioButton) findViewById(R.id.middleRadio);
        RadioButton leftButton = (RadioButton) findViewById(R.id.leftRadio);

        channelDisp.setVisibility(View.VISIBLE);


        switch (v.getId()) {
            case R.id.cancelButton: {
                channelDisp.setText("");
                Intent remoteScreen = new Intent(getApplicationContext(), RemoteActivity.class);
                startActivity(remoteScreen);
                finish();
            }
            case R.id.saveButton: {
                if (radioGroup.getCheckedRadioButtonId() == -1) {
                    System.out.println("Must select radio button");
                } else {
                    if (rightButton.isChecked()) {
                        if (rightSavedChannel > 0) {
                            rightSavedChannel = 0;
                        }
                        rightSavedChannel = rightSavedChannel + Integer.parseInt(channelDisp.getText().toString());
                        channelDisp.setText("");
                    } else if (middleButton.isChecked()) {
                        if (middleSavedChannel > 0) {
                            middleSavedChannel = 0;
                        }
                        middleSavedChannel = middleSavedChannel + Integer.parseInt(channelDisp.getText().toString());
                        channelDisp.setText("");
                    } else if (leftButton.isChecked()) {
                        if (leftSavedChannel > 0) {
                            leftSavedChannel = 0;
                        }
                        leftSavedChannel = leftSavedChannel + Integer.parseInt(channelDisp.getText().toString());
                        channelDisp.setText("");
                    }
                    Intent remoteScreen = new Intent(getApplicationContext(), RemoteActivity.class);
                    startActivity(remoteScreen);
                    finish();
                }
                break;
            }




            case R.id.button0: {
                if (channelDisp.length() < 3) {
                    channelText = channelText + "0";
                    channelDisp.setText(channelText);
                } else {
                    channelText = "";
                    channelText = channelText + "0";
                    channelDisp.setText(channelText);
                }
                break;
            }
            case R.id.button1: {
                if (channelText.length() < 3) {
                    channelText = channelText + "1";
                    channelDisp.setText(channelText);
                } else {
                    channelText = "";
                    channelText = channelText + "1";
                    channelDisp.setText(channelText);
                }
                break;
            }
            case R.id.button2: {
                if (channelText.length() < 3) {
                    channelText = channelText + "2";
                    channelDisp.setText(channelText);
                } else {
                    channelText = "";
                    channelText = channelText + "2";
                    channelDisp.setText(channelText);
                }
                break;
            }

            case R.id.button3: {
                if (channelText.length() < 3) {
                    channelText = channelText + "3";
                    channelDisp.setText(channelText);
                } else {
                    channelText = "";
                    channelText = channelText + "3";
                    channelDisp.setText(channelText);
                }
                break;
            }
            case R.id.button4: {
                if (channelText.length() < 3) {
                    channelText = channelText + "4";
                    channelDisp.setText(channelText);
                } else {
                    channelText = "";
                    channelText = channelText + "4";
                    channelDisp.setText(channelText);
                }
                break;
            }

            case R.id.button5: {
                if (channelText.length() < 3) {
                    channelText = channelText + "5";
                    channelDisp.setText(channelText);
                } else {
                    channelText = "";
                    channelText = channelText + "5";
                    channelDisp.setText(channelText);
                }
                break;
            }
            case R.id.button6: {
                if (channelText.length() < 3) {
                    channelText = channelText + "6";
                    channelDisp.setText(channelText);
                } else {
                    channelText = "";
                    channelText = channelText + "6";
                    channelDisp.setText(channelText);
                }
                break;
            }

            case R.id.button7: {
                if (channelText.length() < 3) {
                    channelText = channelText + "7";
                    channelDisp.setText(channelText);
                } else {
                    channelText = "";
                    channelText = channelText + "7";
                    channelDisp.setText(channelText);
                }
                break;
            }
            case R.id.button8: {
                if (channelText.length() < 3) {
                    channelText = channelText + "8";
                    channelDisp.setText(channelText);
                } else {
                    channelText = "";
                    channelText = channelText + "8";
                    channelDisp.setText(channelText);
                }
                break;
            }

            case R.id.button9: {
                if (channelText.length() < 3) {
                    channelText = channelText + "9";
                    channelDisp.setText(channelText);
                } else {
                    channelText = "";
                    channelText = channelText + "9";
                    channelDisp.setText(channelText);
                }
                break;
            }

            case R.id.channelDecButton: {
                channelValue = Integer.parseInt(String.valueOf(channelDisp.getText()));
                channelValue--;
                if(channelValue<1){
                    channelValue = 1;
                }
                channelDisp.setText(String.valueOf(channelValue));

                break;
            }
            case R.id.channelIncButton: {
                channelValue = Integer.parseInt(String.valueOf(channelDisp.getText()));
                channelValue++;
                if(channelValue > 999){
                    channelValue = 999;
                }
                channelDisp.setText(String.valueOf(channelValue));

                break;
            }
        }
    }


    public static int getLeftChannel(){
        return leftSavedChannel;
    }
    public static int getMiddleChannel(){
        return middleSavedChannel;
    }
    public static int getRightChannel(){
        return rightSavedChannel;
    }
}
