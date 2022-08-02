package com.cruelgeroi.apphub.ui

import com.cruelgeroi.apphub.Colors
import androidx.recyclerview.widget.RecyclerView
import com.cruelgeroi.apphub.ui.ColorsAdapter.MyViewHolder
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.cruelgeroi.apphub.R
import android.widget.TextView
import android.widget.RelativeLayout
import java.util.ArrayList

class ColorsAdapter(private val colorsArrayList: ArrayList<Colors>, private val mOnAdapterListener: OnAdapterClickListener) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_items, parent, false)
        return MyViewHolder(itemView, mOnAdapterListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val number = colorsArrayList[position].number
        val colorName = colorsArrayList[position].colorName
        val color = colorsArrayList[position].color

        holder.numTextView.text = number.toString() + ""
        holder.colorNameTextView.text = colorName
        holder.layout.setBackgroundColor(color)
    }

    override fun getItemCount(): Int {
        return colorsArrayList.size
    }

    inner class MyViewHolder(view: View, onAdapterClickListener: OnAdapterClickListener) : RecyclerView.ViewHolder(view), View.OnClickListener {

        var numTextView: TextView
        var colorNameTextView: TextView
        var layout: RelativeLayout
        var onAdapterClickListener: OnAdapterClickListener

        override fun onClick(v: View) {
            onAdapterClickListener.onAdapterClick(adapterPosition)
        }

        init {
            numTextView = view.findViewById(R.id.numTextView)
            colorNameTextView = view.findViewById(R.id.colorNameTextView)
            layout = view.findViewById(R.id.layoutRecyclerView)
            view.setOnClickListener(this)
            this.onAdapterClickListener = onAdapterClickListener
        }
    }

    interface OnAdapterClickListener {
        fun onAdapterClick(position: Int)
    }
}