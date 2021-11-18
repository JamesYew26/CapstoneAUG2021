package com.example.budgetcalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class PTPTNDBHelper extends SQLiteOpenHelper {
    private Context context;

    public static final String TABLE_NAME = "PTPTN_Expenses";
    public static final String PTPTN1 = "PTPTN1";
    public static final String PTPTN2 = "PTPTN2";
    public static final String PTPTN3 = "PTPTN3";
    public static final String PTPTN4 = "PTPTN4";
    public static final String PTPTN5 = "PTPTN5";
    public static final String PTPTN6 = "PTPTN6";
    public static final String PTPTNSum = "Total_PTPTN";
    public static final String Column_ID = "ID";

    public PTPTNDBHelper(@Nullable Context context) {
        super(context, "PTPTN.db", null, 1);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase DB) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + Column_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PTPTN1 + " INTEGER, " + PTPTN2 + " INTEGER, " + PTPTN3 + " INTEGER, " +
                PTPTN4 + " INTEGER, " + PTPTN5 + " INTEGER, " + PTPTN6 + " INTEGER, " +
                PTPTNSum + " INTEGER )";
        DB.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(DB);
    }

    public void addPTPTNInfo(int PT1, int PT2, int PT3, int PT4, int PT5, int PT6, int PTPTNTotal) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues CV = new ContentValues();

        CV.put(PTPTN1, PT1);
        CV.put(PTPTN2, PT2);
        CV.put(PTPTN3, PT3);
        CV.put(PTPTN4, PT4);
        CV.put(PTPTN5, PT5);
        CV.put(PTPTN6, PT6);
        CV.put(PTPTNSum, PTPTNTotal);

        long result = DB.insert(TABLE_NAME, null, CV);
        if (result==-1){
            Toast.makeText(context,"Error !",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context,"SUCCESS !",Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readPTPTNData(){
        String query = " SELECT Total_PTPTN FROM " + TABLE_NAME + " WHERE ID =(SELECT max(ID) FROM PTPTN_Expenses)";
        SQLiteDatabase DB = this.getReadableDatabase();

        Cursor cursor = null;
        if (DB != null){
            cursor = DB.rawQuery(query,null);
        }
        return cursor;
    }


}
