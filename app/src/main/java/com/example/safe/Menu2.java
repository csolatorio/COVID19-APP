package com.example.safe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Menu2 extends AppCompatActivity {
    ImageView remind, setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);
        setting = (ImageView) findViewById(R.id.setting);
        remind = (ImageView)findViewById(R.id.remind);

        remind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRemind();
            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();

            }
        });
    }
    public void openSettings() {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
    private void openRemind() {
        Intent i = new Intent(this, Reminder.class);
        startActivity(i);
    }
}
