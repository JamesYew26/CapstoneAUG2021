package com.example.budgetcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class salary_activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private String sSalaryCheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary);
    }
    public void SixSalary(View view) {
        Intent intent = new Intent(this, SixSalary.class);
        startActivity(intent);

    }
    public void CheckSalary(View view){
        EditText salary = (EditText) findViewById(R.id.salary_et);
        sSalaryCheck = salary.getText().toString();
        if (sSalaryCheck.matches("")){
            Toast.makeText(this,"Please enter a salary",Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            Intent intent = new Intent(this, InvestQuestion.class);
        startActivity(intent);
        }
    }

    public void InvestQuestion(View view) {

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}