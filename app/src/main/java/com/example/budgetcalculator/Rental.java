package com.example.budgetcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Rental extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental2);
    }

    public void CommissionQuestion(View view) {
        Intent intent = new Intent(this, CommissionQuestion.class);
        startActivity(intent);
    }
}