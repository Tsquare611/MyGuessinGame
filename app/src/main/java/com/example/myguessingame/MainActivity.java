package com.example.myguessingame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

private EditText editText1;
private TextView lossTextView;
private TextView wonTextView;
private Button checkButton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
lossTextView = findViewById(R.id.lossTextViewId);
wonTextView =  findViewById(R.id.wonTextViewId) ;
checkButton1 =  findViewById(R.id.checkButton1Id);
editText1 =  findViewById(R.id.editText1Id);

checkButton1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String  guessString = editText1.getText().toString();
        if (guessString.isEmpty()){
  errorMessage();
        }else {
            int guess = Integer.parseInt(guessString);
            if(guess > 5){
                errorMessage();
            }
            Random random = new Random();

            int randomNumber = random.nextInt(5)+1;

            if(randomNumber==guess){
                wonTextView.setText("Congratulations! You have won.");
            }
            else{
                lossTextView.setText("Sorry! You have lost.Random num was "+randomNumber);
            }
        }

    }
    void errorMessage()
    {
        editText1.setError("Please enter a valid input");
        editText1.requestFocus();
        return ;
    }
}
