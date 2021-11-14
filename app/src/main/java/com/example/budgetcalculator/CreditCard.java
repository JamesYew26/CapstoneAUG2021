package com.example.budgetcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreditCard extends AppCompatActivity {
    Button insert;
    EditText CCard1, CCard2, CCard3, CCard4, CCard5, CCard6;
    public static int sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card);

        CCard1 = findViewById(R.id.CC1);
        CCard2 = findViewById(R.id.CC2);
        CCard3 = findViewById(R.id.CC3);
        CCard4 = findViewById(R.id.CC4);
        CCard5 = findViewById(R.id.CC5);
        CCard6 = findViewById(R.id.CC6);

        insert = findViewById(R.id.Insert_Btn);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int M1 = Integer.valueOf(CCard1.getText().toString());
                int M2 = Integer.valueOf(CCard2.getText().toString());
                int M3 = Integer.valueOf(CCard3.getText().toString());
                int M4 = Integer.valueOf(CCard4.getText().toString());
                int M5 = Integer.valueOf(CCard5.getText().toString());
                int M6 = Integer.valueOf(CCard6.getText().toString());

                sum = M1 + M2 + M3 + M4 + M5 + M6;

                try {
                    CCDatabaseHelper ccDatabaseHelper = new CCDatabaseHelper(CreditCard.this);
                    ccDatabaseHelper.addCCInfo(Integer.valueOf(CCard1.getText().toString()),
                            Integer.valueOf(CCard2.getText().toString()),
                            Integer.valueOf(CCard3.getText().toString()),
                            Integer.valueOf(CCard4.getText().toString()),
                            Integer.valueOf(CCard5.getText().toString()),
                            Integer.valueOf(CCard6.getText().toString()),
                            Integer.valueOf(sum));


                    Intent intent = new Intent(CreditCard.this, PTPTN.class);
                    startActivity(intent);
                }
                catch (Exception e){
                    Toast.makeText(CreditCard.this,"Enter 0 if no credit card expenses", Toast.LENGTH_SHORT).show();

                }
                }
        });
    }
}