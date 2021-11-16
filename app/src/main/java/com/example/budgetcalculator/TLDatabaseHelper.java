package com.example.budgetcalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class TLDatabaseHelper extends SQLiteOpenHelper {

    private Context context;

    public static final String TABLE_NAME = "TermLoan_Expenses";
    public static final String TLoan1 = "TermLoan1";
    public static final String TLoan2 = "TermLoan2";
    public static final String TLoan3 = "TermLoan3";
    public static final String TLoan4 = "TermLoan4";
    public static final String TLoan5 = "TermLoan5";
    public static final String TLoan6 = "TermLoan6";
    public static final String TermLoanSum = "Total_TermLoan";
    public static final String Column_ID = "ID";

    public TLDatabaseHelper(@Nullable Context context) {
        super(context, "TermLoan.db", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + Column_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TLoan1 + " INTEGER, " + TLoan2 + " INTEGER, " + TLoan3 + " INTEGER, " +
                TLoan4 + " INTEGER, " + TLoan5 + " INTEGER, " + TLoan6 + " INTEGER, " +
                TermLoanSum + " INTEGER )";
        DB.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(DB);
    }

    public void addTermLoanInfo(int TL1, int TL2, int TL3, int TL4, int TL5, int TL6, int TLSum) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues CV = new ContentValues();

        CV.put(TLoan1, TL1);
        CV.put(TLoan2, TL2);
        CV.put(TLoan3, TL3);
        CV.put(TLoan4, TL4);
        CV.put(TLoan5, TL5);
        CV.put(TLoan6, TL6);
        CV.put(TermLoanSum, TLSum);

        long result = DB.insert(TABLE_NAME, null, CV);
        if (result==-1){
            Toast.makeText(context,"Error !",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context,"SUCCESS !",Toast.LENGTH_SHORT).show();
        }
    }

}
