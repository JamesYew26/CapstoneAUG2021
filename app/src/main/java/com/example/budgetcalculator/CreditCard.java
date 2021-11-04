package com.example.budgetcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CreditCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card);
    }

    public void PTPTN(View view) {
        Intent intent = new Intent(this, PTPTN.class);
        startActivity(intent);
    }
}