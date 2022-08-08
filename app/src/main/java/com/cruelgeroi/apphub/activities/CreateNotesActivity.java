package com.cruelgeroi.apphub.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ContentValues;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;

import com.cruelgeroi.apphub.R;
import com.cruelgeroi.apphub.db.NotesContract;
import com.cruelgeroi.apphub.ui.NotesAdapter;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class CreateNotesActivity extends AppCompatActivity implements NotesAdapter.OnNotesAdapterCLickListener {

    private TextInputLayout titleTil;
    private TextInputLayout textTil;

    private TextInputEditText titleEt;
    private TextInputEditText textEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_notes);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        titleTil = findViewById(R.id.activity_created_notes_til_1);
        textTil = findViewById(R.id.activity_created_notes_til_2);

        titleEt = findViewById(R.id.activity_created_notes_et_1);
        textEt = findViewById(R.id.activity_created_notes_et_2);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_create_notes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_save:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveNote(){
        String title = titleEt.getText().toString().trim();
        String text = textEt.getText().toString().trim();

        boolean isCorrect = true;

        if (TextUtils.isEmpty(title)){
            isCorrect = false;

            titleTil.setError(getString(R.string.error_null));
            titleTil.setErrorEnabled(true);
        } else{
            titleTil.setErrorEnabled(false);
        }

        if (TextUtils.isEmpty(text)){
            isCorrect = false;

            textTil.setError(getString(R.string.error_null));
            textTil.setErrorEnabled(true);
        } else{
            textTil.setErrorEnabled(false);
        }
        if (isCorrect){
            long currentTime = System.currentTimeMillis();

            ContentValues contentValues = new ContentValues();

            contentValues.put(NotesContract.Notes.COLUMN_TITLE, title);
            contentValues.put(NotesContract.Notes.COLUMN_NOTE, text);
            contentValues.put(NotesContract.Notes.COLUMN_CREATED_TS, currentTime);
            contentValues.put(NotesContract.Notes.COLUMN_UPDATED_TS, currentTime);

            getContentResolver().insert(NotesContract.Notes.URI, contentValues);
            finish();
        }
    }

    @Override
    public void onClick(int position) {

    }
}