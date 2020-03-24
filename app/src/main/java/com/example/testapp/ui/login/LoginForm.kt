package com.example.testapp.ui.login

import android.util.Patterns
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.MutableLiveData


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
