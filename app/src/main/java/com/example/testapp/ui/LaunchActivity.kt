package com.example.testapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.testapp.R
import com.example.testapp.ui.login.LoginFragment

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        // Get the text fragment instance
        val loginFragment = LoginFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.container, loginFragment, "login")
            .commit()
    }


}
