package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendExpressionForComputation(View view) {
        String expression = getInputExpression();
        startActivity(generateIntent(expression));
    }

    private Intent generateIntent(String expression) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, expression);
        return intent;
    }

    private String getInputExpression() {
        EditText editText = findViewById(R.id.editText);
        return editText.getText().toString();
    }
}
