package com.example.testapp.api

import com.example.testapp.model.LoginEntity
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ILoginRepo {

    @POST("user/authenticate")
    suspend fun authenticateUser(@Body body: LoginEntity)
}