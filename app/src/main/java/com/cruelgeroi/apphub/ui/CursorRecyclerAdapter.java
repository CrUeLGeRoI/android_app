package com.cruelgeroi.apphub.ui;

import android.database.Cursor;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cruelgeroi.apphub.db.NotesContract;

import java.util.List;

public abstract class CursorRecyclerAdapter<ViewHolder extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<ViewHolder> {

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


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (!isDataValid) throw new IllegalStateException("Cursor is not valid.");

        if (!cursor.moveToPosition(position)) throw new IllegalStateException("Can\'t move to position: " + position);

        onBindViewHolder(holder, cursor);
    }

    public abstract void onBindViewHolder(ViewHolder viewHolder, Cursor cursor);


    @Override
    public int getItemCount() {
        if (isDataValid && cursor != null)
            return cursor.getCount();
        else
            return 0;
    }

    @Override
    public long getItemId(int position) {
        if (isDataValid && cursor != null) {

            if (cursor.moveToPosition(position)){
                return cursor.getLong(idColumnIndex);
            }

        }
        return RecyclerView.NO_ID;
    }

    public Cursor swapCursor(Cursor newCursor){


        if (newCursor == this.cursor)
            return null;

        Cursor oldCursor = this.cursor;
        this.cursor = newCursor;

        if (newCursor != null) {
            idColumnIndex = newCursor.getColumnIndexOrThrow(NotesContract.Notes._ID);
            isDataValid = true;
            notifyDataSetChanged();
        }
        else {
            idColumnIndex = -1;
            isDataValid = false;
            notifyItemRangeRemoved(0, getItemCount());
        }

        return oldCursor;
    }
}
