package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UsersActivity : AppCompatActivity() {
    lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        var list: List<UserModel.User>? = listOf()

        GlobalScope.launch (Dispatchers.Default){
            var call = UserRetrofitService.retrofit.create(UserApiService::class.java).getUsersList()
            var response = call.execute()

                if(response.isSuccessful){


                    withContext(Dispatchers.Main){
                        list = response.body()?.data
                    }
                }
        }

        findViewById<TextView>(R.id.text).text = list?.size?.toString()

        recycler = findViewById(R.id.recycler)
        var adapter = RecyclerAdapter(this, list!!)

        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)
    }
}