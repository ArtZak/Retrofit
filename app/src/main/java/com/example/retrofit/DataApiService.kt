package com.example.retrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface DataApiService {

    @GET("public-api/products/2")
    fun getData() : Call<DataModel>
}

object DataRetrofitService{
    val retrofit = Retrofit.Builder()
        .baseUrl("https://gorest.co.in/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}