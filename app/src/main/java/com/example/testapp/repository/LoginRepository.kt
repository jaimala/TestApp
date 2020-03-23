package com.example.testapp.repository

import com.example.testapp.api.ILoginRepo
import com.example.testapp.model.LoginEntity
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginRepository {

    suspend fun login(param: LoginEntity) {
        return try {
            val result = ILoginRepo.authenticateUser(param)

        } catch (ex: Throwable) {

        }
    }
}