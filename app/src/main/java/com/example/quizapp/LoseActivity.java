package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoseActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textViewLose;
    Button buttonLose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);

        textViewLose = findViewById(R.id.textViewLose);
        buttonLose = findViewById(R.id.buttonLose);

        textViewLose.setTypeface(SingletonFonts.getInstance(this).getFont1());
        buttonLose.setTypeface(SingletonFonts.getInstance(this).getFont1());
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
