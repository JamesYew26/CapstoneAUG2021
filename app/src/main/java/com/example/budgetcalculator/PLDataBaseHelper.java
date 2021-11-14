package com.example.budgetcalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class PLDataBaseHelper extends SQLiteOpenHelper {

    private Context context;

    public static final String TABLE_NAME = "PersonalLoan";
    public static final String PersonalLoan1 = "PersonalLoan1";
    public static final String PersonalLoan2 = "PersonalLoan2";
    public static final String PersonalLoan3 = "PersonalLoan3";
    public static final String PersonalLoan4 = "PersonalLoan4";
    public static final String PersonalLoan5 = "PersonalLoan5";
    public static final String PersonalLoan6 = "PersonalLoan6";
    public static final String PersonalLoanSum = "Total_PersonalLoan";
    public static final String Column_ID = "ID";




    public PLDataBaseHelper(@Nullable Context context) {
        super(context, "PersonalLoan.db", null, 1);
        this.context = context;
    }

    //this is called the first time a database is accessed. There should be a code inside to create a new database
    @Override
    public void onCreate(SQLiteDatabase DB) {
        String createTableStatement = "CREATE TABLE " + TABLE_NAME +
                " (" + Column_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PersonalLoan1 + " INTEGER, " + PersonalLoan2 + " INTEGER, " + PersonalLoan3 + " INTEGER, " +
                PersonalLoan4 + " INTEGER, " + PersonalLoan5 + " INTEGER, " + PersonalLoan6 + " INTEGER, " +
                PersonalLoanSum + " INTEGER )";
        DB.execSQL(createTableStatement);
    }

    //this is called if the database version number changes.
    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(DB);
    }

    public void addPLInfo(int PL1, int PL2, int PL3, int PL4, int PL5, int PL6, int PLSum) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues CV = new ContentValues();

        CV.put(PersonalLoan1, PL1);
        CV.put(PersonalLoan2, PL2);
        CV.put(PersonalLoan3, PL3);
        CV.put(PersonalLoan4, PL4);
        CV.put(PersonalLoan5, PL5);
        CV.put(PersonalLoan6, PL6);
        CV.put(PersonalLoanSum, PLSum);

        long result = DB.insert(TABLE_NAME, null, CV);
        if (result==-1){
            Toast.makeText(context,"Error !",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context,"SUCCESS !" + PLSum,Toast.LENGTH_SHORT).show();
        }
    }
}
