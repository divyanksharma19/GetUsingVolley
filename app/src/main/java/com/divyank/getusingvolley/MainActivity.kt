package com.divyank.getusingvolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder

class MainActivity : AppCompatActivity() {
    private var url = "https://api.github.com/users"
    private var userInfoItem= arrayListOf<userInfoItem>()
    var userInfo  = userInfo()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var recyclerView=findViewById<RecyclerView>(R.id.rev)
        val stringRequest = StringRequest(url, {
            val gsonBuilder=GsonBuilder()
            val gson=gsonBuilder.create()
            val userInfoArray = gson.fromJson(it, Array<userInfoItem>::class.java)
            userInfoItem.clear() // Clear the previous data in the ArrayList
            userInfoItem.addAll(userInfoArray.toList()) // Convert and add the array items to the ArrayList
            userInfo.clear() // Clear the previous data in the userInfo object
            userInfo.addAll(userInfoArray.toList()) // Convert and add the array items to the userInfo object
            val adaptor=Adapter(this,userInfo)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter=adaptor
        }, {
            Toast.makeText(this,"Something went wrong"+it.toString(),Toast.LENGTH_LONG).show()
        })
        val volleyQueue = Volley.newRequestQueue(this)
        volleyQueue.add(stringRequest)

    }
}