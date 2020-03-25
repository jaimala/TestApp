package com.example.testapp.repository

import com.example.testapp.api.ILoginRepo
import com.example.testapp.model.LoginRequest
import com.example.testapp.model.LoginResponse
import com.example.testapp.model.Resource

/**
 * Repository Class for implementing all Login related services
 */
class LoginRepository {

    private val loginService: ILoginRepo = TODO()

    /**
     * Attempt to authenticate user
     * @param param
     *
     * @return [LoginResponse]
     */
    suspend fun login(param: LoginRequest): Resource<LoginResponse> {
        return try {
            val result = loginService.authenticateUser(param)
            Resource.Data(result)
        } catch (ex: Exception) {
            Resource.Error(ex)
        }
    }



}