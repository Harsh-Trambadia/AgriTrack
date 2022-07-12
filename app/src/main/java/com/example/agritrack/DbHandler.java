package com.example.agritrack;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbHandler extends SQLiteOpenHelper {
    public DbHandler(@Nullable Context context) {
        super(context, "AgriTrack", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String excreate = "CREATE TABLE expense (sno INTEGER PRIMARY KEY, Actname TEXT, value INTEGER)";
        db.execSQL(excreate);

        String crcreate = "CREATE TABLE crop (sno INTEGER PRIMARY KEY, crop TEXT, farm TEXT, fromDate TEXT, toDate TEXT)";
        db.execSQL(crcreate);

        String fcreate = "CREATE TABLE farm (sno INTEGER PRIMARY KEY, farm TEXT, date TEXT)";
        db.execSQL(fcreate);

        String acreate = "CREATE TABLE activity (sno INTEGER PRIMARY KEY, crop TEXT, farm TEXT, date TEXT)";
        db.execSQL(acreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop = String.valueOf("DROP TABLE IF EXISTS");
        db.execSQL(drop, new String[]{"expense", "crop", "farm", "activity"});
        onCreate(db);
    }

    public void addExpense(ExpenseShow exp){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put("Actname", exp.getActname());
        values.put("value", exp.getValue());
        Long k = db.insert("expense", null, values);
        Log.d("expense", Long.toString(k));
        db.close();
    }

    public ArrayList<ExpenseShow> showExpense(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<ExpenseShow> l = new ArrayList<>();

        Cursor cursorEx = db.rawQuery("SELECT * FROM expense", null);
        if (cursorEx.moveToFirst()){
            do{
                l.add(new ExpenseShow(1,cursorEx.getString(1), cursorEx.getInt(2)));
            }while (cursorEx.moveToNext());
        }
        cursorEx.close();
        return l;
    }

    public int showTotal(){
        SQLiteDatabase db = this.getReadableDatabase();
        int total;
        Cursor t = db.rawQuery("select (SUM(value)) AS Total from expense", null);
        if(t.moveToNext()){
            total = t.getInt(t.getColumnIndex("Total"));
        }
        else{
            total = 0;
        }
        return total;
    }
}
