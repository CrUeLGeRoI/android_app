package com.example.tutorial.db;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class NotesProvider extends ContentProvider {

    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    private static final int NOTES = 1;
    private static final int NOTE = 2;

    static {
        URI_MATCHER.addURI(NotesContract.AUTHORITY, "notes", NOTES);
        URI_MATCHER.addURI(NotesContract.AUTHORITY, "notes/#", NOTE);
    }

    private NotesDbHelper notesDbHelper;

    @Override
    public boolean onCreate() {
        notesDbHelper = new NotesDbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase db = notesDbHelper.getReadableDatabase();

        switch (URI_MATCHER.match(uri)) {
            case NOTES:
                if (TextUtils.isEmpty(sortOrder)) {
                    sortOrder = NotesContract.Notes.COLUMN_UPDATED_TS + " DESC";
                }

                return db.query(NotesContract.Notes.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);

            case NOTE:
                String id = uri.getLastPathSegment();

                if (TextUtils.isEmpty(selection)) {
                    selection = NotesContract.Notes._ID + " = ?";
                    selectionArgs = new String[]{id};
                } else {
                    selection = selection + " AND " + NotesContract.Notes._ID + " = ?";

                    String[] newSelectionArgs = new String[selectionArgs.length + 1];

                    System.arraycopy(selectionArgs, 0, newSelectionArgs, 0, selectionArgs.length);

                    newSelectionArgs[newSelectionArgs.length - 1] = id;

                    selectionArgs = newSelectionArgs;
                }

            default:
                return null;
        }
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (URI_MATCHER.match(uri)) {
            case NOTES:
                return NotesContract.Notes.URI_TYPE_NOTE_DIR;
            case NOTE:
                return NotesContract.Notes.URI_TYPE_NOTE_ITEM;
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        SQLiteDatabase db = notesDbHelper.getWritableDatabase();

        switch (URI_MATCHER.match(uri)) {
            case NOTES:
                long rowId = db.insert(NotesContract.Notes.TABLE_NAME,
                        null,
                        values);

            default:
                return null;
        }
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
