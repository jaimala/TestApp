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

            // Get the support fragment manager instance
            val manager : FragmentManager? = fragmentManager


        // Begin the fragment transition using support fragment manager
            val transaction = manager?.beginTransaction()

            // Replace the fragment on container
            transaction?.replace(R.id.fragment_login,loginFragment)
            //transaction?.addToBackStack(null)

            // Finishing the transition
            transaction?.commit()
    }


}
