package com.app.labbca6thsem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "StudentDB.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "students";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_ADDRESS = "address";
    public static final String COL_CONTACT = "contact";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NAME + " TEXT, " +
                COL_ADDRESS + " TEXT, " +
                COL_CONTACT + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // CREATE
    public boolean insertData(String name, String address, String contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, name);
        contentValues.put(COL_ADDRESS, address);
        contentValues.put(COL_CONTACT, contact);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    // READ
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    // UPDATE
    public boolean updateData(String id, String name, String address, String contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, name);
        contentValues.put(COL_ADDRESS, address);
        contentValues.put(COL_CONTACT, contact);
        int result = db.update(TABLE_NAME, contentValues, COL_ID + " = ?", new String[] { id });
        return result > 0;
    }

    // DELETE
    public Integer deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, COL_ID + " = ?", new String[] { id });
    }
}
