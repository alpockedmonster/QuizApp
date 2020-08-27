package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WinActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textViewWin;
    Button buttonWin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        textViewWin = findViewById(R.id.textViewWin);
        buttonWin = findViewById(R.id.buttonWin);

        textViewWin.setTypeface(SingletonFonts.getInstance(this).getFont1());
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
