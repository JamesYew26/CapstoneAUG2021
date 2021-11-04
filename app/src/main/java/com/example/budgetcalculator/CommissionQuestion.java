package com.example.budgetcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CommissionQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commission_question);
    }

    public void CommissionActivity(View view) {
        Intent intent = new Intent(this, CommissionActivity.class);
        startActivity(intent);
    }

    public void MortgageActivity(View view) {
        Intent intent = new Intent(this, ExpenseActivity.class);
        startActivity(intent);
    }
}