package com.example.budgetcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InvestQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invest_question);
    }

    public void InvestActivity(View view) {
        Intent intent = new Intent(this, InvestActivity.class);
        startActivity(intent);
    }

    public void RentalActivity(View view) {
        Intent intent = new Intent(this, RentalActivity.class);
        startActivity(intent);
    }
}