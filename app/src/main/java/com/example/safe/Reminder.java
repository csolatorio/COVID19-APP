package com.example.safe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Reminder extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        ImageView b = (ImageView)findViewById(R.id.btn_add);

        b.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(Reminder.this, Pop.class));
            }
        });

    }

    public String getActivity() {
        return null;
    }

    public Integer getTime() {
        return null;
    }
}
