package com.cruelgeroi.apphub.ui;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.cruelgeroi.apphub.R;
import com.cruelgeroi.apphub.db.NotesContract;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class NotesAdapter extends CursorRecyclerAdapter<NotesAdapter.ViewHolder>{

    private ArrayList<Cursor> cursors;
    private OnNotesAdapterCLickListener listener;

    public NotesAdapter(Cursor cursor) {
        super(cursor);
    }

    @NonNull
    @Override
    public NotesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_items_note, parent, false);

        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(NotesAdapter.ViewHolder viewHolder, Cursor cursor) {

        int titleColumnIndex = cursor.getColumnIndexOrThrow(NotesContract.Notes.COLUMN_TITLE);
        String title = cursor.getString(titleColumnIndex);

        viewHolder.titleTv.setText(title);

        int dateColumnIndex = cursor.getColumnIndexOrThrow(NotesContract.Notes.COLUMN_UPDATED_TS);
        long updatedTs = cursor.getLong(dateColumnIndex);
        Date date = new Date(updatedTs);

        viewHolder.dateTv.setText(viewHolder.SDF.format(date));
    }



    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView titleTv;
        public TextView dateTv;
        final SimpleDateFormat SDF = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        private final OnNotesAdapterCLickListener listener;


        public ViewHolder(@NonNull View view, OnNotesAdapterCLickListener listener) {
            super(view);
            this.titleTv = view.findViewById(R.id.title_tv);
            this.dateTv = view.findViewById(R.id.date_tv);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    listener.onClick();
                }
            });
            this.listener = listener;


        }
    }
    public interface OnNotesAdapterCLickListener{
        void onClick(int position);
    }
}
