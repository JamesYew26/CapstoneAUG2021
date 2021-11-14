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

                try {
                    HPDatabaseHelper hpDatabaseHelper = new HPDatabaseHelper(HirePurchase.this);
                    hpDatabaseHelper.addHirePurchaseInfo(Integer.valueOf(HP1.getText().toString()),
                            Integer.valueOf(HP2.getText().toString()),
                            Integer.valueOf(HP3.getText().toString()),
                            Integer.valueOf(HP4.getText().toString()),
                            Integer.valueOf(HP5.getText().toString()),
                            Integer.valueOf(HP6.getText().toString()));

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