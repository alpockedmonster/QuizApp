package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textViewQuestions;
    TextView textViewNumber;
    TextView textViewLife;
    TextView textViewLife2;
    Button buttonAnswer1;
    Button buttonAnswer2;
    Button buttonAnswer3;
    Button buttonAnswer4;
    DataQuestions dataQ;
    private int numberOfQuestion = 0; //для контоля номера вопроса
    private int numberOfLives = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewQuestions = findViewById(R.id.textViewQuestions);
        textViewNumber = findViewById(R.id.textViewNumber);
        textViewLife = findViewById(R.id.textViewLife);
        textViewLife2 = findViewById(R.id.textViewLife2);
        buttonAnswer1 = findViewById(R.id.buttonAnswer1);
        buttonAnswer2 = findViewById(R.id.buttonAnswer2);
        buttonAnswer3 = findViewById(R.id.buttonAnswer3);
        buttonAnswer4 = findViewById(R.id.buttonAnswer4);

        //текст для вопроса
        dataQ = new DataQuestions();
        String number = Integer.toString(numberOfQuestion + 1) + '.';
        textViewQuestions.setText(dataQ.questions[0][0]);
        textViewNumber.setText(number);
        buttonAnswer1.setText(dataQ.questions[0][1]);
        buttonAnswer2.setText(dataQ.questions[0][2]);
        buttonAnswer3.setText(dataQ.questions[0][3]);
        buttonAnswer4.setText(dataQ.questions[0][4]);

        //для подгрузки собственных шрифтов
        textViewQuestions.setTypeface(SingletonFonts.getInstance(this).getFont1());
        textViewNumber.setTypeface(SingletonFonts.getInstance(this).getFont1());
        textViewLife.setTypeface(SingletonFonts.getInstance(this).getFont1());
        textViewLife2.setTypeface(SingletonFonts.getInstance(this).getFont1());
        textViewLife2.setTypeface(SingletonFonts.getInstance(this).getFont1());
        buttonAnswer1.setTypeface(SingletonFonts.getInstance(this).getFont1());
        buttonAnswer2.setTypeface(SingletonFonts.getInstance(this).getFont1());
        buttonAnswer3.setTypeface(SingletonFonts.getInstance(this).getFont1());
        buttonAnswer4.setTypeface(SingletonFonts.getInstance(this).getFont1());

    }

    @Override
    public void onClick(View v) {
        Button button = findViewById(v.getId());
        String answer = button.getText().toString();
        if (answer.equals(dataQ.answers[numberOfQuestion])) {
            numberOfQuestion = controlQuestions(numberOfQuestion);
            if (numberOfQuestion == 0)
            {
                Intent intent = new Intent(this, WinActivity.class);
                startActivity(intent);
            }
            String number = Integer.toString(numberOfQuestion + 1) + '.';
            textViewQuestions.setText(dataQ.questions[numberOfQuestion][0]);
            textViewNumber.setText(number);
            buttonAnswer1.setText(dataQ.questions[numberOfQuestion][1]);
            buttonAnswer2.setText(dataQ.questions[numberOfQuestion][2]);
            buttonAnswer3.setText(dataQ.questions[numberOfQuestion][3]);
            buttonAnswer4.setText(dataQ.questions[numberOfQuestion][4]);
        } else {

            if (numberOfLives > 1) {
                numberOfLives--;
                String number = Integer.toString(numberOfLives);
                textViewLife.setText(number);
                new upgradeQuestions().execute();

            }
            else
            {
                Intent intent = new Intent(this, LoseActivity.class);
                startActivity(intent);
            }
        }

    }

    public int controlQuestions (int numberOfQuestion) {
            int maxLengthMas = 6; //количество строк в двумерном массиве
            if (numberOfQuestion < maxLengthMas)
                numberOfQuestion++;
            else
                numberOfQuestion = 0;
            return numberOfQuestion;
    }

    class upgradeQuestions extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            //выводим уведомление
            Toast toast = Toast.makeText(getApplicationContext(),
                    R.string.leftLives, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            LinearLayout toastContainer = (LinearLayout) toast.getView();
            //toastContainer.setBackgroundColor(Color.TRANSPARENT);
            ImageView sadImageView = new ImageView(getApplicationContext());
            sadImageView.setImageResource(R.drawable.icon_toast1);
            toastContainer.addView(sadImageView, 0);
            toast.show();

        }
    }
}
