package com.example.tutorial.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutorial.ColorsOfRainbow;
import com.example.tutorial.R;

import java.util.ArrayList;

public class ColorsOfRainbowAdapter extends RecyclerView.Adapter<ColorsOfRainbowAdapter.MyViewHolder> {

    private ArrayList<ColorsOfRainbow> colorsOfRainbowArrayList;
    private OnAdapterClickListener mOnAdapterListener;

    public ColorsOfRainbowAdapter(ArrayList<ColorsOfRainbow> colorsOfRainbowArrayList, OnAdapterClickListener onAdapterClickListener) {
        this.colorsOfRainbowArrayList = colorsOfRainbowArrayList;
        this.mOnAdapterListener = onAdapterClickListener;
    }

    @NonNull
    @Override
    public ColorsOfRainbowAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(itemView, mOnAdapterListener);
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

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView numTextView;
        TextView colorNameTextView;
        RelativeLayout layout;
        OnAdapterClickListener onAdapterClickListener;

        public MyViewHolder(@NonNull View view, OnAdapterClickListener onAdapterClickListener) {
            super(view);
            numTextView = view.findViewById(R.id.numTextView);
            colorNameTextView = view.findViewById(R.id.colorNameTextView);
            layout = view.findViewById(R.id.layoutRecyclerView);


            view.setOnClickListener(this);
            this.onAdapterClickListener = onAdapterClickListener;
        }

        @Override
        public void onClick(View v) {
            onAdapterClickListener.onAdapterClick(getAdapterPosition());
        }
    }
    public interface OnAdapterClickListener{
        void onAdapterClick(int position);
    }
}
