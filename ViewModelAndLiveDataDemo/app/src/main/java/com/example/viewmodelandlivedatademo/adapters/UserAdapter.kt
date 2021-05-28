package com.example.viewmodelandlivedatademo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodelandlivedatademo.R
import com.example.viewmodelandlivedatademo.models.User

class UserAdapter (private val context: Context, private var userlist:ArrayList<User> ):
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rcv_item_layout,parent,false))

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user=userlist[position]
        holder.name.text=user.name
    }

    override fun getItemCount(): Int =userlist.size


    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val name: TextView =itemView.findViewById(R.id.tv_name)
    }
    fun setUserData(userList: ArrayList<User>)
    {
        this.userlist=userList
        notifyDataSetChanged()
    }
}