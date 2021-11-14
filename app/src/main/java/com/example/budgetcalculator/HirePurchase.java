package com.example.budgetcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HirePurchase extends AppCompatActivity {

    Button insert;
    EditText HP1,HP2,HP3,HP4,HP5,HP6;
    public static int sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire_purchase);

        HP1 = findViewById(R.id.HP1);
        HP2 = findViewById(R.id.HP2);
        HP3 = findViewById(R.id.HP3);
        HP4 = findViewById(R.id.HP4);
        HP5 = findViewById(R.id.HP5);
        HP6 = findViewById(R.id.HP6);

        insert = findViewById(R.id.Insert_Btn);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int M1 = Integer.valueOf(HP1.getText().toString());
                int M2 = Integer.valueOf(HP2.getText().toString());
                int M3 = Integer.valueOf(HP3.getText().toString());
                int M4 = Integer.valueOf(HP4.getText().toString());
                int M5 = Integer.valueOf(HP5.getText().toString());
                int M6 = Integer.valueOf(HP6.getText().toString());

                sum = M1 + M2 + M3 + M4 + M5 + M6;

                try {
                    HPDatabaseHelper hpDatabaseHelper = new HPDatabaseHelper(HirePurchase.this);
                    hpDatabaseHelper.addHirePurchaseInfo(Integer.valueOf(HP1.getText().toString()),
                            Integer.valueOf(HP2.getText().toString()),
                            Integer.valueOf(HP3.getText().toString()),
                            Integer.valueOf(HP4.getText().toString()),
                            Integer.valueOf(HP5.getText().toString()),
                            Integer.valueOf(HP6.getText().toString()),
                            Integer.valueOf(sum));

                    Intent intent = new Intent(HirePurchase.this, TermLoan.class);
                    startActivity(intent);
                }
                catch (Exception e){
                    Toast.makeText(HirePurchase.this,"Enter 0 if no hire purchase", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

}