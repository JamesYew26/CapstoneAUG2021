package com.example.budgetcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TermLoan extends AppCompatActivity {
    Button insert;
    EditText TL1, TL2, TL3, TL4, TL5, TL6;
    public static int sum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_loan);

        TL1 = findViewById(R.id.TL1);
        TL2 = findViewById(R.id.TL2);
        TL3 = findViewById(R.id.TL3);
        TL4 = findViewById(R.id.Mort2);
        TL5 = findViewById(R.id.TL5);
        TL6 = findViewById(R.id.TL6);

        insert = findViewById(R.id.Insert_Btn);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    int M1 = Integer.valueOf(TL1.getText().toString());
                    int M2 = Integer.valueOf(TL2.getText().toString());
                    int M3 = Integer.valueOf(TL3.getText().toString());
                    int M4 = Integer.valueOf(TL4.getText().toString());
                    int M5 = Integer.valueOf(TL5.getText().toString());
                    int M6 = Integer.valueOf(TL6.getText().toString());

                    sum = M1 + M2 + M3 + M4 + M5 + M6;

                    TLDatabaseHelper tlDatabaseHelper = new TLDatabaseHelper(TermLoan.this);
                    tlDatabaseHelper.addTermLoanInfo(Integer.valueOf(TL1.getText().toString()),
                            Integer.valueOf(TL2.getText().toString()),
                            Integer.valueOf(TL3.getText().toString()),
                            Integer.valueOf(TL4.getText().toString()),
                            Integer.valueOf(TL5.getText().toString()),
                            Integer.valueOf(TL6.getText().toString()),
                            Integer.valueOf(sum));

                    Intent intent = new Intent(TermLoan.this, PersonalLoan.class);
                    startActivity(intent);
                }
                catch (Exception e){
                    Toast.makeText(TermLoan.this,"Enter 0 if no term loan", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}