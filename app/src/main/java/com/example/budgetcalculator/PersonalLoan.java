package com.example.budgetcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.opengl.GLDebugHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.database.Cursor;

import java.util.ArrayList;

public class PersonalLoan extends AppCompatActivity {
    Button insert;
    EditText PLoan1, PLoan2, PLoan3, PLoan4, PLoan5, PLoan6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_loan);


        PLoan1 = findViewById(R.id.PL1);
        PLoan2 = findViewById(R.id.PL2);
        PLoan3 = findViewById(R.id.PL3);
        PLoan4 = findViewById(R.id.PL4);
        PLoan5 = findViewById(R.id.PL5);
        PLoan6 = findViewById(R.id.PL6);

        insert = findViewById(R.id.Insert_Btn);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    PLDataBaseHelper plDB = new PLDataBaseHelper(PersonalLoan.this);
                    plDB.addPLInfo(Integer.valueOf(PLoan1.getText().toString()),
                            Integer.valueOf(PLoan2.getText().toString()),
                            Integer.valueOf(PLoan3.getText().toString()),
                            Integer.valueOf(PLoan4.getText().toString()),
                            Integer.valueOf(PLoan5.getText().toString()),
                            Integer.valueOf(PLoan6.getText().toString()));

                    Intent intent = new Intent(PersonalLoan.this,CreditCard.class);
                    startActivity(intent);
                }
                catch (Exception e ){
                    Toast.makeText(PersonalLoan.this,"Enter 0 if no personal loan", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}