package com.example.george.alaram;

import android.app.AlarmManager;
import android.app.PendingIntent;
import java.util.Calendar;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    TimePicker timePicker;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;
    ToggleButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        timePicker = (TimePicker)findViewById(R.id.time);

        btn = (ToggleButton) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long time;
                if (btn.isChecked()){
                    Toast.makeText(getApplicationContext(),"ALARM ON",Toast.LENGTH_LONG).show();
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.MINUTE,timePicker.getCurrentMinute());
                    calendar.set(Calendar.HOUR_OF_DAY,timePicker.getCurrentHour());
                    Intent intent = new Intent(getApplicationContext(),AlarmReciever.class);
                    pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),0,intent,0);

                    time = (calendar.getTimeInMillis()-(calendar.getTimeInMillis()%60000));
                    if (System.currentTimeMillis()>time){
                        if (calendar.AM_PM == 0){
                            time = time + (1000*60*60*12);
                        }
                        else{
                            time = time + (1000*60*60*24);
                        }
                    }
                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,time,10000,pendingIntent);
                }
                else{
                    alarmManager.cancel(pendingIntent);
                    Toast.makeText(MainActivity.this,"ALARM OFF",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
