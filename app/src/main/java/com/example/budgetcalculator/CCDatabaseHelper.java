package com.example.budgetcalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class CCDatabaseHelper extends SQLiteOpenHelper {

    private Context context;

    private static final String TABLE_NAME = "CreditCardExpenses";
    private static final String COLUMN_1 = "Month1_CreditCard";
    private static final String COLUMN_2 = "Month2_CreditCard";
    private static final String COLUMN_3 = "Month3_CreditCard";
    private static final String COLUMN_4 = "Month4_CreditCard";
    private static final String COLUMN_5 = "Month5_CreditCard";
    private static final String COLUMN_6 = "Month6_CreditCard";
    public static final String CreditCardSum = "Total_CreditCard";
    private static final String COLUMN_ID = "ID";



    public CCDatabaseHelper(@Nullable Context context) {
        super(context, "CreditCardExpenses.db", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_1 + " INTEGER, " + COLUMN_2 + " INTEGER, " + COLUMN_3 + " INTEGER," +
                COLUMN_4 + " INTEGER, " + COLUMN_5 + " INTEGER, " + COLUMN_6 + " INTEGER," +
                CreditCardSum + " INTEGER )";
        DB.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(DB);
    }

    void addCCInfo(int CC1, int CC2, int CC3, int CC4, int CC5, int CC6, int CCSum) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues CV = new ContentValues();

        CV.put(COLUMN_1, CC1);
        CV.put(COLUMN_2, CC2);
        CV.put(COLUMN_3, CC3);
        CV.put(COLUMN_4, CC4);
        CV.put(COLUMN_5, CC5);
        CV.put(COLUMN_6, CC6);
        CV.put(CreditCardSum, CCSum);

        long result = DB.insert(TABLE_NAME, null, CV);
        if (result==-1){
            Toast.makeText(context,"Error !",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context,"SUCCESS !",Toast.LENGTH_SHORT).show();
        }
    }
    Cursor readCreditCardData(){
        String query = " SELECT Total_CreditCard FROM " + TABLE_NAME + " WHERE ID =(SELECT max(ID) FROM CreditCardExpenses)";
        SQLiteDatabase DB = this.getReadableDatabase();

        Cursor cursor = null;
        if (DB != null){
            cursor = DB.rawQuery(query,null);
        }
        return cursor;
    }
}
