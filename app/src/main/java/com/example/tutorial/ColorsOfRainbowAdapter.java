package com.example.tutorial;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ColorsOfRainbowAdapter extends RecyclerView.Adapter<ColorsOfRainbowAdapter.MyViewHolder> {

    private ArrayList<ColorsOfRainbow> colorsOfRainbowArrayList;

    public ColorsOfRainbowAdapter(ArrayList<ColorsOfRainbow> colorsOfRainbowArrayList) {
        this.colorsOfRainbowArrayList = colorsOfRainbowArrayList;
    }

    @NonNull
    @Override
    public ColorsOfRainbowAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorsOfRainbowAdapter.MyViewHolder holder, int position) {
        short number = colorsOfRainbowArrayList.get(position).getNumber();
        String colorName = colorsOfRainbowArrayList.get(position).getColorName();
        int color = colorsOfRainbowArrayList.get(position).getColor();


        holder.numTextView.setText(number + "");
        holder.colorNameTextView.setText(colorName);
        holder.layout.setBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return colorsOfRainbowArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView numTextView;
        private TextView colorNameTextView;
        private RelativeLayout layout;

        public MyViewHolder(@NonNull View view) {
            super(view);
            numTextView = view.findViewById(R.id.numTextView);
            colorNameTextView = view.findViewById(R.id.colorNameTextView);
            layout = view.findViewById(R.id.layoutRecyclerView);
        }
    }
}
