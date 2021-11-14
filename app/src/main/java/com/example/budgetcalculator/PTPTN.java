package com.example.budgetcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PTPTN extends AppCompatActivity {
    Button insert;
    EditText PTPTN1, PTPTN2, PTPTN3, PTPTN4, PTPTN5, PTPTN6;
    public static int sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptptn);

        PTPTN1 = findViewById(R.id.PTPTN1);
        PTPTN2 = findViewById(R.id.PTPTN2);
        PTPTN3 = findViewById(R.id.PTPTN3);
        PTPTN4 = findViewById(R.id.PTPTN4);
        PTPTN5 = findViewById(R.id.PTPTN5);
        PTPTN6 = findViewById(R.id.PTPTN6);

        insert = findViewById(R.id.Insert_Btn);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int M1 = Integer.valueOf(PTPTN1.getText().toString());
                int M2 = Integer.valueOf(PTPTN2.getText().toString());
                int M3 = Integer.valueOf(PTPTN3.getText().toString());
                int M4 = Integer.valueOf(PTPTN4.getText().toString());
                int M5 = Integer.valueOf(PTPTN5.getText().toString());
                int M6 = Integer.valueOf(PTPTN6.getText().toString());

                sum = M1 + M2 + M3 + M4 + M5 + M6;

                try {
                    PTPTNDBHelper ptptndbHelper = new PTPTNDBHelper(PTPTN.this);
                    ptptndbHelper.addPTPTNInfo(Integer.valueOf(PTPTN1.getText().toString()),
                            Integer.valueOf(PTPTN2.getText().toString()),
                            Integer.valueOf(PTPTN3.getText().toString()),
                            Integer.valueOf(PTPTN4.getText().toString()),
                            Integer.valueOf(PTPTN5.getText().toString()),
                            Integer.valueOf(PTPTN6.getText().toString()),
                            Integer.valueOf(sum));

                    Intent intent = new Intent(PTPTN.this,Summary.class);
                    startActivity(intent);
                }

                catch (Exception e){
                    Toast.makeText(PTPTN.this,"Enter 0 if no PTPTN", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}