package com.example.tutorial.db

import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase

class NotesDbHelper(context: Context?) : SQLiteOpenHelper(context, NotesContract.DB_NAME, null, NotesContract.DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        for (query in NotesContract.CREATE_DATABASE_QUERIES) {
            db.execSQL(query)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}
}