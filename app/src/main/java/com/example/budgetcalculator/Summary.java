package com.example.budgetcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Summary extends AppCompatActivity {
    //Declaring databases
    MortDatabaseHelper MortDB;
    CCDatabaseHelper CCDB;
    HPDatabaseHelper HPDB;
    PLDataBaseHelper PLDB;
    PTPTNDBHelper PTPTNDB;
    TLDatabaseHelper TLDB;

    //Declaring CustomAdapter
    CustomAdapter customAdapter;

    //Declaring lists following YouTube
    ArrayList<String> MortSum, HPsum, TLsum, PLsum, CCsum, PTPTNsum;;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        //Declaring all the database helper
        MortDB = new MortDatabaseHelper(Summary.this);
        CCDB = new CCDatabaseHelper(Summary.this);
        HPDB = new HPDatabaseHelper(Summary.this);
        PLDB = new PLDataBaseHelper(Summary.this);
        PTPTNDB = new PTPTNDBHelper(Summary.this);
        TLDB = new TLDatabaseHelper(Summary.this);

        //Recycler View
        recyclerView = findViewById(R.id.recyclerView);

        //Sum of the variables
        MortSum = new ArrayList<>();
        HPsum = new ArrayList<>();
        TLsum = new ArrayList<>();
        PLsum = new ArrayList<>();
        CCsum = new ArrayList<>();
        PTPTNsum = new ArrayList<>();

        loadDataFromMortDB();
        loadDataFromHPDB();
        loadDataFromTermLoanDB();
        loadDataFromPersonalLoanDB();
        loadDataFromCreditCardDB();
        loadDataFromPTPTNDB();

        customAdapter = new CustomAdapter(Summary.this,MortSum,HPsum,TLsum,PLsum,CCsum,PTPTNsum);

        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Summary.this));
    }


     void loadDataFromMortDB() {
        Cursor cursor = MortDB.readMortgageData();

        if (cursor == null){
            Toast.makeText(this,"No data",Toast.LENGTH_SHORT).show();
        }
        else{
            while (cursor.moveToNext()){
                MortSum.add(cursor.getString(0));
            }
        }
    }

    void loadDataFromHPDB() {
        Cursor cursor = HPDB.readHirePurchaseData();

        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                HPsum.add(cursor.getString(0));
            }
        }
    }

    void loadDataFromTermLoanDB() {
        Cursor cursor = TLDB.readTermLoanData();

        if (cursor == null) {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                TLsum.add(cursor.getString(0));
            }
        }
    }

        void loadDataFromPersonalLoanDB() {
            Cursor cursor = PLDB.readPersonalLoanData();

            if (cursor == null){
                Toast.makeText(this,"No data",Toast.LENGTH_SHORT).show();
            }
            else{
                while (cursor.moveToNext()){
                    PLsum.add(cursor.getString(0));
                }
            }
        }

    void loadDataFromCreditCardDB() {
        Cursor cursor = CCDB.readCreditCardData();

        if (cursor == null){
            Toast.makeText(this,"No data",Toast.LENGTH_SHORT).show();
        }
        else{
            while (cursor.moveToNext()){
                CCsum.add(cursor.getString(0));
            }
        }
    }

    void loadDataFromPTPTNDB() {
        Cursor cursor = PTPTNDB.readPTPTNData();

        if (cursor == null){
            Toast.makeText(this,"No data",Toast.LENGTH_SHORT).show();
        }
        else{
            while (cursor.moveToNext()){
                PTPTNsum.add(cursor.getString(0));

            }
        }
    }

}