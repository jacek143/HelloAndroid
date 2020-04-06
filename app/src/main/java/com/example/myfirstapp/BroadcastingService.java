package com.example.myfirstapp;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

public class BroadcastingService extends Service {
    Runnable runnable;
    static Handler handler;

    public BroadcastingService() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                Log.d(this.getClass().getSimpleName(), "Service running");
                handler.postDelayed(runnable, 2000);
            }
        };
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(this.getClass().getSimpleName(), "Service started");
        handler.postDelayed(runnable, 2000);
        return Service.START_NOT_STICKY;
    }
}
