package com.qualflow.webservices

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var userList: List<User> = mutableListOf()

    fun setUsers(users: List<User>) {
        userList = users
        notifyDataSetChanged()
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvEmail: TextView = itemView.findViewById(R.id.tvEmail)
        val tvPhone: TextView = itemView.findViewById(R.id.tvPhone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)

        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val itemViewModel = userList[position]

        holder.tvName.text = itemViewModel.name
        holder.tvEmail.text = itemViewModel.email
        holder.tvPhone.text = itemViewModel.phone
    }

}