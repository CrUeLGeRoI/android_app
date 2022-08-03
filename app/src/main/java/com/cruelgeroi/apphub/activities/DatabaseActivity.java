package com.cruelgeroi.apphub.activities;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cruelgeroi.apphub.db.NotesContract;
import com.cruelgeroi.apphub.R;
import com.cruelgeroi.apphub.ui.NotesAdapter;

public class DatabaseActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private NotesAdapter notesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        getSupportLoaderManager().initLoader(
                0, // Идентификатор загрузчика
                null, // Аргументы
                this // Callback для событий загрузчика
        );

        RecyclerView recyclerView = findViewById(R.id.notes_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        notesAdapter = new NotesAdapter(null);
        recyclerView.setAdapter(notesAdapter);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        insert();
//        select();
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(
                this,  // Контекст
                NotesContract.Notes.URI, // URI
                NotesContract.Notes.LIST_PROJECTION, // Столбцы
                null, // Параметры выборки
                null, // Аргументы выборки
                null // Сортировка по умолчанию
        );
    }
    @Nullable
    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        Log.i("Test", "Load finished: " + cursor.getCount());

        cursor.setNotificationUri(getContentResolver(), NotesContract.Notes.URI);
        notesAdapter.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
    }

    private void insert() {
        ContentResolver contentResolver = getContentResolver();

        ContentValues contentValues = new ContentValues();
        contentValues.put(NotesContract.Notes.COLUMN_TITLE, "Заголовок заметки");
        contentValues.put(NotesContract.Notes.COLUMN_NOTE, "Текст заметки");
        contentValues.put(NotesContract.Notes.COLUMN_CREATED_TS, System.currentTimeMillis());
        contentValues.put(NotesContract.Notes.COLUMN_UPDATED_TS, System.currentTimeMillis());

        Uri uri = contentResolver.insert(NotesContract.Notes.URI, contentValues);
        Log.i("Test", "URI: " + uri);
    }

    private void select() {
        ContentResolver contentResolver = getContentResolver();

        Cursor cursor = contentResolver.query(
                NotesContract.Notes.URI, // URI
                NotesContract.Notes.LIST_PROJECTION, // Столбцы
                null, // Параметры выборки
                null, // Аргументы выборки
                null // Сортировка по умолчанию
        );

        Log.i("Test", "Count: " + cursor.getCount());

        cursor.close();
    }
}