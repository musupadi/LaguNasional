package com.destiny.lagunasionalindonesia.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class DB_Helper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "lagunasional.db";
    private static final int DATABASE_VERSION = 3;
    public static final String TABLE_NAME = "lagunasional";
    public static final String COLUMN_JUDUL = "judul";
    public static final String COLUMN_PENCIPTA = "pencipta";
    public static final String COLUMN_ASAL = "asal";
    public static final String COLUMN_LIRIK = "lirik";
    public static final String COLUMN_LAGU = "lagu";


    public DB_Helper(Context context){super(
            context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" (" +
                COLUMN_JUDUL+" TEXT NOT NULL, "+
                COLUMN_PENCIPTA+" TEXT NOT NULL,"+
                COLUMN_ASAL+" TEXT NOT NULL,"+
                COLUMN_LIRIK+" TEXT NOT NULL,"+
                COLUMN_LAGU+" TEXT NOT NULL);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);
    }
    public List<Models> modelList() {
        String query = "SELECT  * FROM " + TABLE_NAME;
        List<Models> modelLinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Models model;

        if (cursor.moveToFirst()) {
            do {
                model = new Models();
                model.setJudul(cursor.getString(cursor.getColumnIndex(COLUMN_JUDUL)));
                model.setPencipta(cursor.getString(cursor.getColumnIndex(COLUMN_PENCIPTA)));
                model.setAsal(cursor.getString(cursor.getColumnIndex(COLUMN_ASAL)));
                model.setLirik(cursor.getString(cursor.getColumnIndex(COLUMN_LIRIK)));
                model.setLagu(cursor.getString(cursor.getColumnIndex(COLUMN_LAGU)));
                modelLinkedList.add(model);
            } while (cursor.moveToNext());
        }
        return modelLinkedList;
    }
    public void FavoriteLagu(Models models) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_JUDUL, models.getJudul());
        values.put(COLUMN_PENCIPTA,models.getPencipta());
        values.put(COLUMN_ASAL,models.getAsal());
        values.put(COLUMN_LIRIK,models.getLirik());
        values.put(COLUMN_LAGU,models.getLagu());
        db.insert(TABLE_NAME,null, values);
        db.close();
    }
    public void deleteLaguRecord(String nama, Context context) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_NAME+" WHERE nama='"+nama+"'");
        Toast.makeText(context, "Deleted successfully.", Toast.LENGTH_SHORT).show();

    }
}
