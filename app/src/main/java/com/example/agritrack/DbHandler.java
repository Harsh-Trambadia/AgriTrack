package com.example.agritrack;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
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

        String acreate = "CREATE TABLE activity (sno INTEGER PRIMARY KEY, actName TEXT, crop TEXT, farm TEXT, date TEXT)";
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

    public void addFarm(FarmShow fs){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put("farm", fs.getFarm());
        values.put("date", fs.getDate());
        long k = db.insert("farm", null, values);
        Log.d("farm", Long.toString(k));
    }

    public ArrayList<FarmShow> showFarms(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<FarmShow> f = new ArrayList<>();

        Cursor cursorFs = db.rawQuery("select * from farm", null);
        if (cursorFs.moveToFirst()){
            do{
                f.add(new FarmShow(1, cursorFs.getString(1), cursorFs.getString(2)));
            }while (cursorFs.moveToNext());
        }
        cursorFs.close();
        return f;
    }

    public ArrayList<String> getFarmName(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> fn = new ArrayList<>();

        Cursor cursorfn = db.rawQuery("select farm from farm", null);

        if (cursorfn.moveToFirst()){
            do{
                fn.add(cursorfn.getString(0));

            }while (cursorfn.moveToNext());
        }
        cursorfn.close();
        return fn;
    }

    public void AddCrops(CropShow crp){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("crop", crp.getCrop());
        values.put("farm", crp.getFarm());
        values.put("fromDate", crp.getFromDate());
        values.put("toDate", crp.getToDate());

        long k = db.insert("crop", null, values);
        Log.d("crop", Long.toString(k));
    }

    public ArrayList<CropShow> ShowCrop(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<CropShow> Fs = new ArrayList<>();

        Cursor cursorFs = db.rawQuery("select * from crop", null);
        if (cursorFs.moveToFirst()){
            do{
                Fs.add(new CropShow(1, cursorFs.getString(1), cursorFs.getString(2), cursorFs.getString(3), cursorFs.getString(4)));
            }while (cursorFs.moveToNext());
        }
        cursorFs.close();
        return Fs;
    }

    public ArrayList<String> getCropName(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> cn = new ArrayList<>();

        Cursor cursorcn = db.rawQuery("select crop from crop", null);

        if (cursorcn.moveToFirst()){
            do{
                cn.add(cursorcn.getString(0));
            }while (cursorcn.moveToNext());
        }
        cursorcn.close();
        return cn;
    }

    public void addActivity(ActivityShow as){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("actName", as.getActName());
        values.put("crop", as.getCrop());
        values.put("farm", as.getFarm());
        values.put("date", as.getDate());

        Long k = db.insert("activity", null, values);
        Log.d("activity", Long.toString(k));
    }

    public ArrayList<ActivityShow> showActivity(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<ActivityShow> as = new ArrayList<>();

        Cursor cursoract = db.rawQuery("select * from activity", null);

        if (cursoract.moveToFirst()){
            do{
                as.add(new ActivityShow(1, cursoract.getString(1), cursoract.getString(2),
                        cursoract.getString(3), cursoract.getString(4)));
            }while (cursoract.moveToNext());
        }
        cursoract.close();
        return as;
    }
}
