package com.example.budgetcalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class HPDatabaseHelper extends SQLiteOpenHelper {

    private Context context;

    public static final String TABLE_NAME = "HirePurchase_Expenses";
    public static final String HPurchase1 = "HirePurchase1";
    public static final String HPurchase2 = "HirePurchase2";
    public static final String HPurchase3 = "HirePurchase3";
    public static final String HPurchase4 = "HirePurchase4";
    public static final String HPurchase5 = "HirePurchase5";
    public static final String HPurchase6 = "HirePurchase6";
    public static final String HirePurchaseSum = "Total_HirePurchase";
    public static final String Column_ID = "ID";

    public HPDatabaseHelper(@Nullable Context context) {
        super(context, "HirePurchase.db", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + Column_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                HPurchase1 + " INTEGER, " + HPurchase2 + " INTEGER, " + HPurchase3 + " INTEGER, " +
                HPurchase4 + " INTEGER, " + HPurchase5 + " INTEGER, " + HPurchase6 + " INTEGER, " +
                HirePurchaseSum + " INTEGER )";
        DB.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(DB);
    }

    public void addHirePurchaseInfo(int HP1, int HP2, int HP3, int HP4, int HP5, int HP6, int HPSum) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues CV = new ContentValues();

        CV.put(HPurchase1, HP1);
        CV.put(HPurchase2, HP2);
        CV.put(HPurchase3, HP3);
        CV.put(HPurchase4, HP4);
        CV.put(HPurchase5, HP5);
        CV.put(HPurchase6, HP6);
        CV.put(HirePurchaseSum, HPSum);

        long result = DB.insert(TABLE_NAME, null, CV);
        if (result==-1){
            Toast.makeText(context,"Error !",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context,"SUCCESS ! ",Toast.LENGTH_SHORT).show();
        }
    }
}
