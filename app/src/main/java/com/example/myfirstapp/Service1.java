package com.example.myfirstapp;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

public class Service1 extends Service {
    private int DELAY_MILLIS = 1000;
    private Handler handler;
    private Runnable runnable;

    public Service1() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(AppStringConstants.INCREMENT_ACTION);
                sendBroadcast(intent);
                Log.d(AppStringConstants.LOG_TAG, "Service running");
                handler.postDelayed(runnable, DELAY_MILLIS);
            }
        };
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(AppStringConstants.LOG_TAG, "Service started");
        handler.postDelayed(runnable, DELAY_MILLIS);
        return Service.START_NOT_STICKY;
    }

    public @Override
    void onDestroy() {
        handler.removeCallbacks(runnable);
    }
}
