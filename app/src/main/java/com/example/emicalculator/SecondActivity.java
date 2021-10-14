package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class SecondActivity extends AppCompatActivity {

    private int principleAmount;
    private int durationAmount;
    private double interestAmount;
    private static DecimalFormat REAL_FORMATTER = new DecimalFormat("0.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView emiTextView = (TextView) findViewById(R.id.emiValue);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            principleAmount = extras.getInt("principle");
            durationAmount = extras.getInt("duration");
            interestAmount = extras.getDouble("interest");
        }

        double result = emiCalculation(principleAmount, durationAmount*12, interestAmount / 1200);
        emiTextView.setText("$" + REAL_FORMATTER.format(result));
    }

    public double emiCalculation(int principle, int duration, double interest){
        double calculation = (principle * interest * Math.pow(1 + interest, duration)) / (Math.pow(1 + interest, duration) - 1);
        return calculation;
    }
}