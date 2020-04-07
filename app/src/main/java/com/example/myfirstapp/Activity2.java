package com.example.myfirstapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Activity2 extends AppCompatActivity {
    static int counter = 0;
    BroadcastReceiver1 receiver = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        registerReceiver();
        updateCounterView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    private void registerReceiver() {
        receiver = new BroadcastReceiver1();
        IntentFilter filter = new IntentFilter(AppStringConstants.INCREMENT_ACTION);
        this.registerReceiver(receiver, filter);
    }

    private void updateCounterView() {
        TextView textView = findViewById(R.id.messageDisplay);
        textView.setText(String.format(Locale.getDefault(), "%d", counter));
    }

    public class BroadcastReceiver1 extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(AppStringConstants.LOG_TAG, "Intent received");
            counter++;
            updateCounterView();
        }
    }
}
