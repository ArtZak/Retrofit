package com.example.retrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface UserApiService {

    @GET("api/users?page=2")
    fun getUsersList(): Call<UserModel>
}

object UserRetrofitService{
    var retrofit = Retrofit.Builder()
        .baseUrl("https://reqres.in/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}