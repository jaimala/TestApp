package com.example.testapp.ui.login

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapp.model.Resource.Data

import com.example.testapp.model.Resource.Error
import com.example.testapp.model.LoginRequest

import com.example.testapp.repository.LoginRepository


/**
 * ViewModel Class for Login View
 *
 * @property loginRepository
 */
 class LoginViewModel(private val loginRepository: LoginRepository, application: Application) :
    ViewModel() {

    // Variable to check if response is successful
    val responseStatus = MutableLiveData<Any>()

    // Variable to check if response is successful
    val responseStatusVerificationEmailPost = MutableLiveData<Boolean>()

    // Variable for Login Form data
    var login: LoginForm? = null

    // LiveData for observing change in loginField i.e if all validations are passed value is set and observed
    val loginFields: MutableLiveData<LoginForm.LoginFields>?
        get() = login?.loginFields

    init {
        login = LoginForm()

    }

      suspend fun authenticateUser(toString: Any, toString1: Any) {

        val email = loginFields?.value?.email
        val password = loginFields?.value?.password
        if (!email.isNullOrBlank() && !password.isNullOrBlank() ) {
            val loginResult = loginRepository.login(
                LoginRequest(
                    email,
                    password
                )
            )
            when (loginResult) {
                is Data<*> -> {
                    loginResult.data.let { loginResponse ->
                        when {
                            responseStatus.equals("Success")  -> {

                                responseStatus.postValue(true)
                            }
                            else -> responseStatus.postValue(responseStatus)
                        }
                    }
                }
                }
            }
        }

    fun onLoginClick() {
        login?.onClick()
    }




}
