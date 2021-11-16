package com.example.budgetcalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MortDatabaseHelper extends SQLiteOpenHelper {

    private Context context;

    public static final String TABLE_NAME = "Mortgage_Expenses";
    public static final String Mort1 = "Mortgage1";
    public static final String Mort2 = "Mortgage2";
    public static final String Mort3 = "Mortgage3";
    public static final String Mort4 = "Mortgage4";
    public static final String Mort5 = "Mortgage5";
    public static final String Mort6 = "Mortgage6";
    public static final String MortSum = "Total_Mortgage";
    public static final String Column_ID = "ID";

    public MortDatabaseHelper(@Nullable Context context) {
        super(context, "Mortgage.db", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + Column_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Mort1 + " INTEGER, " + Mort2 + " INTEGER, " + Mort3 + " INTEGER, " +
                Mort4 + " INTEGER, " + Mort5 + " INTEGER, " + Mort6 + " INTEGER, " +
                MortSum + " INTEGER )";
        DB.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(DB);
    }
    public void addMortgageInfo(int M1, int M2, int M3, int M4, int M5, int M6, int MSum) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues CV = new ContentValues();

        CV.put(Mort1, M1);
        CV.put(Mort2, M2);
        CV.put(Mort3, M3);
        CV.put(Mort4, M4);
        CV.put(Mort5, M5);
        CV.put(Mort6, M6);
        CV.put(MortSum, MSum);

        long result = DB.insert(TABLE_NAME, null, CV);
        if (result==-1){
            Toast.makeText(context,"Error !",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context,"SUCCESS !",Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readMortgageData(){
        String query = " SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase DB = this.getReadableDatabase();

        Cursor cursor = null;
        if (DB != null){
            DB.rawQuery(query,null);
        }
        return cursor;
    }


}
