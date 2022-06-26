package com.example.tutorial.ui;

import android.database.Cursor;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tutorial.db.NotesContract;

public abstract class CursorRecyclerAdapter<ViewHolder extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected Cursor cursor;
    protected boolean isDataValid;
    protected int idColumnIndex;

    public CursorRecyclerAdapter(Cursor cursor){
        super();

        this.cursor = cursor;

        isDataValid = cursor != null;

        idColumnIndex = cursor != null ? cursor.getColumnIndexOrThrow(NotesContract.Notes._ID) : -1;

        setHasStableIds(true);
    }
}
