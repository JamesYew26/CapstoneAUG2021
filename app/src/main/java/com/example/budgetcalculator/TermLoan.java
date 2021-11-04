package com.example.budgetcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TermLoan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_loan);
    }

    public void PersonalLoan(View view) {
        Intent intent = new Intent(this, PersonalLoan.class);
        startActivity(intent);
    }
}