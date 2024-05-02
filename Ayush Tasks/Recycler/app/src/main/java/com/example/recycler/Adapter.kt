package com.example.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.setMargins
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler.R

class Adapter(private val itemCount: Int) : RecyclerView.Adapter<Adapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val layoutParams = holder.itemView.layoutParams as ViewGroup.MarginLayoutParams

        if (position == itemCount) {
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT

        } else {

            layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT

        }

        holder.itemView.layoutParams = layoutParams

    }

    override fun getItemCount(): Int {
        return itemCount
    }
}

