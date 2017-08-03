package com.example.tops.newalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by tops on 8/2/2017.
 */

public class Broadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "ok set alarm done", Toast.LENGTH_SHORT).show();
        Log.e("alarm", "genereted...");
    }
}
