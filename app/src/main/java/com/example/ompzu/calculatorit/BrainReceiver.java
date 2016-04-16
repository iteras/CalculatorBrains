package com.example.ompzu.calculatorit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Ompzu on 4/15/2016.
 */
public class BrainReceiver extends BroadcastReceiver{
    public String TAG = "Broadcast Brain";

    public void onReceive(Context ctx, Intent i){
        Bundle extras = i.getExtras();
        String debuggable = "";
        if (extras != null){
            debuggable = extras.toString();
            MainActivity.saveInput(debuggable);
        }
        Toast.makeText(ctx,"Intent received " + debuggable, Toast.LENGTH_SHORT ).show();
        if(BuildConfig.DEBUG){
            Log.d(TAG, "Broadcast BRAIN onReceive " +  debuggable);
            if(debuggable.isEmpty()){
                Log.d(TAG, "Broadcast failed, instant didn't contain anything stringable" );
            }
        }
    }
}
