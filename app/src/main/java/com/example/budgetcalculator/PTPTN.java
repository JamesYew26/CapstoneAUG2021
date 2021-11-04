package com.example.budgetcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PTPTN extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptptn);
    }

    public void Summary(View view) {
        Intent intent = new Intent(this, Summary.class);
        startActivity(intent);
    }
}