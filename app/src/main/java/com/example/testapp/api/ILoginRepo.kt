package com.example.testapp.api



import com.example.testapp.data.LoginResponse
import com.example.testapp.data.LoginRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface ILoginRepo {

    /**
     * Authenticate User as per credentials
     * @param body
     *
     * @return [LoginResponse]
     */
    @POST("user/authenticate")
    suspend fun authenticateUser(
        @Body body: LoginRequest
    ): LoginResponse
}