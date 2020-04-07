package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Activity1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startNewIncrementationService(View view) {
        Log.d(AppStringConstants.LOG_TAG, "Start broadcasting service");
        Intent intent = new Intent(this, Service1.class);
        startService(intent);
    }

    public void showActivityWithBroadcastReceiver(View view) {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

    public void stopAllIncrementationServices(View view) {
        Log.d(AppStringConstants.LOG_TAG, "Stop broadcasting services");
        Intent intent = new Intent(this, Service1.class);
        stopService(intent);
    }
}
