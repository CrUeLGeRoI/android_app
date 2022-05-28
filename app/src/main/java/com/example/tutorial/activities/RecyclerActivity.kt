package com.example.tutorial.activities;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.tutorial.ColorsOfRainbow;
import com.example.tutorial.ui.ColorsOfRainbowAdapter;
import com.example.tutorial.R;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity implements ColorsOfRainbowAdapter.OnAdapterClickListener{

    private ArrayList<ColorsOfRainbow> colorsOfRainbowArrayList;
    private RecyclerView recyclerView;
    private TextView numTextView, colorNameTextView;
    private short[] numbers = new short[]{1, 2, 3, 4, 5, 6, 7, 8};
    private String[] colorsName = new String[]{"Красный", "Желтый", "Синий", "Зеленый", "Серый", "Фиолетовый", "Бирюзовый", "Белый"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        int[] colors = new int[]{ContextCompat.getColor(this, R.color.red),
                ContextCompat.getColor(this, R.color.yellow),
                ContextCompat.getColor(this, R.color.blue),
                ContextCompat.getColor(this, R.color.green),
                ContextCompat.getColor(this, R.color.grey),
                ContextCompat.getColor(this, R.color.purple),
                ContextCompat.getColor(this, R.color.teal_700),
                ContextCompat.getColor(this, R.color.white)};

        recyclerView = findViewById(R.id.recyclerView);

        numTextView = findViewById(R.id.numTextView);
        colorNameTextView = findViewById(R.id.colorNameTextView);

        colorsOfRainbowArrayList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            colorsOfRainbowArrayList.add(new ColorsOfRainbow(numbers[i], colorsName[i], colors[i]));
        }

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        ColorsOfRainbowAdapter adapter = new ColorsOfRainbowAdapter(colorsOfRainbowArrayList, this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onAdapterClick(int position) {
        Log.d(TAG, "onAdapterClick: clicked");
        Intent intent = new Intent(this, CreatedActivity.class);
        intent.putExtra("COLOR_OF_ELEMENT", colorsOfRainbowArrayList.get(position).getColor());
        startActivity(intent);
    }
}