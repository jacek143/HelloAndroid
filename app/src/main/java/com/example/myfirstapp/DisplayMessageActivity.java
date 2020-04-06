package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayMessageActivity extends AppCompatActivity {
    private ExpressionProcessor processor = new ExpressionProcessor(new AndroidLog());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        displayResult(processExpression(getExpression()));
    }

    private String getExpression() {
        Intent intent = getIntent();
        return intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
    }

    private void displayResult(String result) {
        TextView textView = findViewById(R.id.messageDisplay);
        textView.setText(result);
    }

    private String processExpression(String expression) {
        return processor.run(expression);
    }
}
