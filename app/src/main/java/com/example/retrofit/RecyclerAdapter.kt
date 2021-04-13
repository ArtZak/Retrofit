package com.example.retrofit

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.util.zip.Inflater

class RecyclerAdapter(val context: Context, val data: List<UserModel.User>): RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.users_row, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val currentItem = data[position]

        holder.id.text = currentItem.id.toString()
        holder.fName.text = currentItem.firstName
        holder.lName.text = currentItem.lastName
        holder.email.text = currentItem.email
        Picasso.get().load(currentItem.avatar).into(holder.img)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class CustomViewHolder(view: View): RecyclerView.ViewHolder(view){
        var id: TextView
        var email: TextView
        var fName: TextView
        var lName: TextView
        var img: ImageView

        init {
            id = view.findViewById(R.id.id)
            email = view.findViewById(R.id.email)
            fName = view.findViewById(R.id.f_name)
            lName = view.findViewById(R.id.l_name)
            img = view.findViewById(R.id.img)
        }
    }
}