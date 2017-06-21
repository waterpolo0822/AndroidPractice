package com.example.george.wifi;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity  {
    Button bt1,bt2;
    WifiManager wm;
    BluetoothAdapter bt=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = (Button)findViewById(R.id.bt1);
        bt2 = (Button)findViewById(R.id.bt2);
        bt = BluetoothAdapter.getDefaultAdapter();
        bt1.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            wm = (WifiManager)getApplicationContext().getSystemService(WIFI_SERVICE);
            if (wm.isWifiEnabled()){
                bt1.setText("wifi on");
                wm.setWifiEnabled(false);
            }
            else{
                bt1.setText("wifi off");
                wm.setWifiEnabled(true);
            }
        }
    });
        bt2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (bt == null){
                Toast.makeText(MainActivity.this,"No blue tooth found",Toast.LENGTH_LONG).show();
            }
            else{
                if (!bt.isEnabled()){
                    bt.enable();
                    bt2.setText("bluetooth on");
                    Toast.makeText(MainActivity.this,"Blue tooth found",Toast.LENGTH_LONG).show();
                }
                else{
                    bt.disable();
                    bt2.setText("bluetooth off");
                }
            }

        }
    });
    }

}
