package com.example.tutorial.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class NotesDbHelper extends SQLiteOpenHelper {
    public NotesDbHelper(@Nullable Context context) {
        super(context, NotesContract.DB_NAME, null, NotesContract.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for (String query : NotesContract.CREATE_DATABASE_QUERIES) {
            db.execSQL(query);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
