package com.example.budgetcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PersonalLoan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_loan);
    }

    public void CreditCard(View view) {
        Intent intent = new Intent(this, CreditCard.class);
        startActivity(intent);
    }
}