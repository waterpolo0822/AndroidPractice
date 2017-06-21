package com.example.george.alarm;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AnalogClock;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;

public class MainActivity extends Activity {
    TextView tv;
    Context context = null;
    protected BroadcastReceiver mTimeInfoReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            tv = (TextView)findViewById(R.id.text);
            Calendar calendar = Calendar.getInstance();
            Toast.makeText(getApplicationContext(),"Current time is --- :-"+calendar.getTime(),Toast.LENGTH_LONG).show();
            tv.setText(""+calendar.getTime());
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_TIME_TICK);
        registerReceiver(mTimeInfoReceiver,intentFilter);

    }
}
