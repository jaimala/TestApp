package com.example.testapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class LoginEntity(
    @field:Expose @field:SerializedName("UserName") val userName: String,
    @field:Expose @field:SerializedName("Password") private val password: String,
    @field:Expose @field:SerializedName("Captcha_Token") private val captchaToken: String
)

