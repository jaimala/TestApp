package com.example.testapp.model

import com.google.gson.annotations.SerializedName

/**
 * Model representing API authenticate Login response
 *
 * @property loginData
 * @property errorMsg
 * @property responseCode
 * @property statusCode
 */
data class LoginResponse(
    @SerializedName("data")
    val errorMsg: Any,
    val responseCode: String,
    val statusCode: Int
)

