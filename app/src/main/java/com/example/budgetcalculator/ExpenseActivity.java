package com.example.budgetcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ExpenseActivity extends AppCompatActivity {

    Button insert;
    EditText Mort1,Mort2,Mort3,Mort4,Mort5,Mort6;
    public static int sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        Mort1 = findViewById(R.id.Mort1);
        Mort2 = findViewById(R.id.Mort2);
        Mort3 = findViewById(R.id.Mort3);
        Mort4 = findViewById(R.id.Mort4);
        Mort5 = findViewById(R.id.Mort5);
        Mort6 = findViewById(R.id.Mort6);

        insert = findViewById(R.id.Insert_Btn);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    int M1 = Integer.valueOf(Mort1.getText().toString());
                    int M2 = Integer.valueOf(Mort2.getText().toString());
                    int M3 = Integer.valueOf(Mort3.getText().toString());
                    int M4 = Integer.valueOf(Mort4.getText().toString());
                    int M5 = Integer.valueOf(Mort5.getText().toString());
                    int M6 = Integer.valueOf(Mort6.getText().toString());

                    sum = M1 + M2 + M3 + M4 + M5 + M6;

                    MortDatabaseHelper mortDatabaseHelper = new MortDatabaseHelper(ExpenseActivity.this);
                    mortDatabaseHelper.addMortgageInfo(Integer.valueOf(Mort1.getText().toString()),
                            Integer.valueOf(Mort2.getText().toString()),
                            Integer.valueOf(Mort3.getText().toString()),
                            Integer.valueOf(Mort4.getText().toString()),
                            Integer.valueOf(Mort5.getText().toString()),
                            Integer.valueOf(Mort6.getText().toString()),
                            Integer.valueOf(sum));

                    Intent intent = new Intent(ExpenseActivity.this, HirePurchase.class);
                    startActivity(intent);
                }
                catch (Exception e){
                   Toast.makeText(ExpenseActivity.this,"Enter 0 if no mortgages", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

}