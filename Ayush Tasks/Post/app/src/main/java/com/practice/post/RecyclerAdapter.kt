package com.practice.post

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerAdapter(private var dataList: List<LoginUserResponse>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textUsername: TextView = itemView.findViewById(R.id.name)
        val textEmail: TextView = itemView.findViewById(R.id.pass)
        val profilePic: ImageView = itemView.findViewById(R.id.imageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.textUsername.text = item.userName
        holder.textEmail.text = item.email
        Glide.with(holder.itemView)
            .load(item.image)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error_image)
            .into(holder.profilePic)
    }

    override fun getItemCount(): Int = dataList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newDataList: List<LoginUserResponse>) {
        dataList = newDataList
        notifyDataSetChanged()
    }
}
