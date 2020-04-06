package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.step";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startBroadcastingService(View view) {
        Log.d(this.getClass().getSimpleName(), "Start broadcasting service");
        Intent intent = new Intent(this, BroadcastingService.class);
        intent.putExtra(EXTRA_MESSAGE, getStep());
        startService(intent);
    }

    private String getStep() {
        EditText editText = findViewById(R.id.editText);
        return editText.getText().toString();
    }
}
