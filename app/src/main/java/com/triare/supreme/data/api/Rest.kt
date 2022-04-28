package com.triare.supreme.data.api


import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Rest {

    private val gson: Gson by lazy {
        GsonBuilder()
            .setLenient()
            .create()
    }
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("http://ergast.com/")
            .build()
    }
    val apiService: RacingService by lazy {
        retrofit.create(RacingService::class.java)
    }

}
