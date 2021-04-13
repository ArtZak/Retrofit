package com.example.retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.create

class MainActivity : AppCompatActivity() {
    lateinit var idView: TextView
    lateinit var nameView: TextView
    lateinit var descriptionView: TextView
    lateinit var priceView: TextView
    lateinit var discountView: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        idView = findViewById(R.id.id)
        nameView = findViewById(R.id.name)
        descriptionView = findViewById(R.id.desc)
        priceView = findViewById(R.id.price)
        discountView = findViewById(R.id.discount)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            val intent = Intent(this, UsersActivity::class.java)
            startActivity(intent)
        }

        var id: Int?
        var name: String?
        var description: String?
        var price: String?
        var discount_amount: String?

        GlobalScope.launch (Dispatchers.Default){
            val call = DataRetrofitService.retrofit.create(DataApiService::class.java).getData()
            val response = call.execute()

            if (response.isSuccessful){
                id = response.body()?.data?.id
                name = response.body()?.data?.name
                description = response.body()?.data?.description
                price = response.body()?.data?.price
                discount_amount = response.body()?.data?.discount_amount

                withContext(Dispatchers.Main){
                    idView.text = id?.toString()
                    nameView.text = name
                    descriptionView.text = description
                    priceView.text = price
                    discountView.text = discount_amount
                }
            }
        }
    }
}