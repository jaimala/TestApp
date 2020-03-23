package com.example.testapp.ui.login

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LoginViewModel : ViewModel(){

    var livedata:MutableLiveData<Boolean> = MutableLiveData<Boolean>()

    val userid = ObservableField<String>("UserID")
    val passwd = ObservableField<String>("Password")

    fun onLoginClick() {
        Log.i("Login", "Click View model")



        livedata.value = true
    }

}