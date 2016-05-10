package com.example.ompzu.calculatorit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Ompzu on 4/15/2016.
 */
public class BrainReceiver extends BroadcastReceiver{
    public static String TAG = "Broadcast Brain";

    public void onReceive(Context ctx, Intent i){
        Bundle extras;
        try{
             extras = i.getExtras();
        } catch (RuntimeException e){
            Log.d(TAG, "intent extra is empty!");
            return;
        }

        String debuggable = "";
        if (extras != null){
            debuggable = extras.getString("input");
            Log.d(TAG,"Intent contains: " + i.getStringExtra("input"));
            Toast.makeText(ctx,TAG + " Intent received " + debuggable, Toast.LENGTH_LONG).show();
            start(debuggable);
            //MainActivity.saveInput(debuggable);
        }
        if(BuildConfig.DEBUG){
            Log.d(TAG, " onReceive " +  debuggable);
            if(debuggable.isEmpty()){
                Log.d(TAG, "Broadcast failed, instant didn't contain anything stringable" );
            }
        }
    }

    public static void start(String str){
        Log.d(TAG,"Worked so far!");
        new MainActivity().saveInput(str);

    }
}
