package com.example.testapp.util

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Util {

  inline  fun <reified T> createWebService(
        okHttpClient: OkHttpClient
    ): T {
        val baseUrl = "'http://demo2708806.mockable.io/movies/"

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        return retrofit.create(T::class.java)
    }
}