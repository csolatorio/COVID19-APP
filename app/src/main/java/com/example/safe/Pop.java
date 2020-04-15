package com.example.safe;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.Calendar;


public class Pop extends Activity{

     Spinner spinner1;
     EditText time;
     TimePickerDialog timePickerDialog;
     Calendar calendar;
     int currentHour;
     int currentMinute;
     String amPm;
//    int hourOfDay12 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popwindow);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.5));

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        time = (EditText) findViewById(R.id.time);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Pop.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(myAdapter);

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(Pop.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if (hourOfDay >= 12){
                            hourOfDay = hourOfDay - 12;
                            amPm = "PM";
                        }else {
                            amPm = "AM";
                        }
//                        time.setText(String.format("%02d:%02d", hourOfDay, minutes) + amPm);
                        time.setText(hourOfDay + ":" + minutes + " " + amPm);
                    }
                }, currentHour, currentMinute, false);
                timePickerDialog.show();

            }
        });

    }
}
