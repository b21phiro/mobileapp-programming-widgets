package com.example.widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button counterButton = findViewById(R.id.counterButton);
        Button resetButton = findViewById(R.id.resetCounterButton);

        final TextView counterDisplay = findViewById(R.id.counterDisplay);

        counterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();
                displayScore(counterDisplay);
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
                displayScore(counterDisplay);
            }
        });

    }

    private void add() {
        score++;
    }

    private void reset() {
        score = 0;
    }

    private void displayScore(TextView display) {
        display.setText(String.valueOf(score));
    }

}
