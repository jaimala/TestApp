package com.example.testapp.ui.login

import android.app.Application
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.data.Resource.Data

import com.example.testapp.data.Resource.Error
import com.example.testapp.data.LoginRequest

import com.example.testapp.repository.LoginRepository


/**
 * ViewModel Class for Login View
 *
 * @property userRepository
 */
 class LoginViewModel(private val loginRepository: LoginRepository, application: Application) :
    ViewModel() {

    // Variable to check if response is successful
    val responseStatus = MutableLiveData<Any>()

    // Variable to check if response is successful
    val responseStatusVerificationEmailPost = MutableLiveData<Boolean>()

    // Variable for Login Form data
    var login: LoginForm? = null

    // Email On focus listener to handle validation
    var emailOnFocusChangeListener: View.OnFocusChangeListener? = null

    // Password on focus listener to handle validation
    var passwordOnFocusChangeListener: View.OnFocusChangeListener? = null

    // LiveData for observing change in loginField i.e if all validations are passed value is set and observed
    val loginFields: MutableLiveData<LoginForm.LoginFields>?
        get() = login?.loginFields

    init {
        login = LoginForm()

    }

    /**
     * Attempt to authenticate user
     */
    suspend fun authenticateUser() {

        val email = loginFields?.value?.email
        val password = loginFields?.value?.password
        if (email != null && password != null) {
            val loginResult = loginRepository.login(
                LoginRequest(
                    email,
                    password
                )
            )
            when (loginResult) {
                is Data -> {
                    loginResult.data.let { loginResponse ->
                        when {
                            loginResponse.responseCode == "Success" -> {

                                responseStatus.postValue(true)
                            }
                            else -> responseStatus.postValue(loginResponse.statusCode)
                        }
                    }
                }
                is Error -> {



                    }
                }
            }
        }




    /**
     * Attempts to login
     */
    fun onLoginClick() {
        login?.onClick()
    }




}
