package com.example.testapp.ui.login

import androidx.lifecycle.MutableLiveData

/**
 * LoginForm Class handling all validation and values
 */
class LoginForm  {
    class LoginFields {
        var email: String? = null
        var password: String? = null
    }

    val fields = LoginFields()

    val loginFields = MutableLiveData<LoginFields>()

    // method called from LoginViewModel on login button click
    fun onClick() {
        loginFields.value = fields
    }
}
