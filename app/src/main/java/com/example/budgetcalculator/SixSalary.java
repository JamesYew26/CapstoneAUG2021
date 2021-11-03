package com.example.budgetcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SixSalary extends AppCompatActivity {
    private String CheckSalary1;
    private String CheckSalary2;
    private String CheckSalary3;
    private String CheckSalary4;
    private String CheckSalary5;
    private String CheckSalary6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six_salary);
    }

    public void InvestQuestion(View view) {
        EditText salary1 = (EditText) findViewById(R.id.salary_et1);
        EditText salary2 = (EditText) findViewById(R.id.salary_et2);
        EditText salary3 = (EditText) findViewById(R.id.salary_et3);
        EditText salary4 = (EditText) findViewById(R.id.salary_et4);
        EditText salary5 = (EditText) findViewById(R.id.salary_et5);
        EditText salary6 = (EditText) findViewById(R.id.salary_et6);

        CheckSalary1 = salary1.getText().toString();
        CheckSalary2 = salary2.getText().toString();
        CheckSalary3 = salary3.getText().toString();
        CheckSalary4 = salary4.getText().toString();
        CheckSalary5 = salary5.getText().toString();
        CheckSalary6 = salary6.getText().toString();

        if (CheckSalary1.matches("") || CheckSalary2.matches("") ||
                CheckSalary3.matches("") || CheckSalary4.matches("") ||
                CheckSalary5.matches("") || CheckSalary6.matches("")){
            Toast.makeText(this,"Put 0 if there is no income",Toast.LENGTH_LONG).show();
        }
        else {
            Intent intent = new Intent(this, InvestQuestion.class);
            startActivity(intent);
        }
    }
}