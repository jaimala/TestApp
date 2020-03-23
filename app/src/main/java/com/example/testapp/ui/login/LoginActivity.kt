package com.example.testapp.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil

import androidx.lifecycle.Observer
import com.example.testapp.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var vb: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        var vb: ActivityMainBinding = DataBindingUtil.inflate(layoutInflater, R.layout.activity_main, null, false)
        setContentView(vb.root)

        var vm = ViewModelProviders.of(this).get(MainViewModel::class.java)
        vb.mainViewModel = vm

        vm.livedata.observe(this, Observer {
            Log.i("Login", "Click View Activity")

    }
}
