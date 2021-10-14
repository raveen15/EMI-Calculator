package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText principleText = (EditText) findViewById(R.id.principalAmountTextBox);
        EditText durationText = (EditText) findViewById(R.id.durationTextBox);
        EditText interestText = (EditText) findViewById(R.id.interestTextBox);

        FloatingActionButton myFab = (FloatingActionButton) findViewById(R.id.fab);

        myFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                String principleString = principleText.getText().toString();
                String durationString = durationText.getText().toString();
                String interestString = interestText.getText().toString();

                int principleAmount = Integer.parseInt(principleString);
                int durationAmount = Integer.parseInt(durationString);
                double interestAmount = Double.parseDouble(interestString);

                intent.putExtra("principle",principleAmount);
                intent.putExtra("duration",durationAmount);
                intent.putExtra("interest",interestAmount);
                startActivity(intent);
            }
        });
    }
}