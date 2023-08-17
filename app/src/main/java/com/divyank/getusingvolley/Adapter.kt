package com.divyank.getusingvolley

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(val context:Context,val userInfo:userInfo):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =LayoutInflater.from(context).inflate(R.layout.single_row,parent,false)
        return ViewHolder(view)
    }
    private class ViewHolder(view: View):RecyclerView.ViewHolder(view)



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ViewHolder) {
            Glide.with(context).load(userInfo.get(position).avatar_url).into(holder.itemView.findViewById(R.id.imageView))
            holder.itemView.findViewById<TextView>(R.id.textView).text = userInfo.get(position).login
        }
    }


    override fun getItemCount(): Int {
       return userInfo.size
    }


}