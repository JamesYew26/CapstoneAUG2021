package com.example.budgetcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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
    ArrayList<String> MortID, Mort1, Mort2, Mort3, Mort4, Mort5, Mort6, MortSum;
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

        recyclerView = findViewById(R.id.RV_Mort);

        MortID = new ArrayList<>();
        Mort1 = new ArrayList<>();
        Mort2 = new ArrayList<>();
        Mort3 = new ArrayList<>();
        Mort4 = new ArrayList<>();
        Mort5 = new ArrayList<>();
        Mort6 = new ArrayList<>();
        MortSum = new ArrayList<>();

        loadDataFromDB();

        customAdapter = new CustomAdapter(Summary.this,MortID,Mort1,Mort2,Mort3,
                Mort4,Mort5,Mort6,MortSum);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Summary.this));

    }

     void loadDataFromDB() {
        Cursor cursor = MortDB.readMortgageData();
        if (cursor.getCount()==0){
            Toast.makeText(this,"No data",Toast.LENGTH_SHORT).show();
        }
        else{
            while (cursor.moveToNext()){
                MortID.add(cursor.getString(0));
                Mort1.add(cursor.getString(1));
                Mort2.add(cursor.getString(2));
                Mort3.add(cursor.getString(3));
                Mort4.add(cursor.getString(4));
                Mort5.add(cursor.getString(5));
                Mort6.add(cursor.getString(6));
                MortSum.add(cursor.getString(7));
            }
        }
    }


}