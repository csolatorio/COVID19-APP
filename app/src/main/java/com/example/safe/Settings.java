package com.example.safe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    TextView textView;
    Switch aSwitch;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        textView = findViewById(R.id.text);
        aSwitch = findViewById(R.id.switch1);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Build.VERSION.SDK_INT >= 26){
                    vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                }else {
                    vibrator.vibrate(500);
                }
            }
        });

    }
}
