package com.example.george.alaram;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.widget.Toast;

/**
 * Created by george on 2017/06/21.
 */

public class AlarmReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Wake up,Wake up",Toast.LENGTH_LONG).show();
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);

        if (uri == null){
            uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        Ringtone ringtone = RingtoneManager.getRingtone(context,uri);
        ringtone.play();
    }
}
