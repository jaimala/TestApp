package com.example.testapp.ui.login


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


import androidx.lifecycle.Observer
import com.example.testapp.R
import com.example.testapp.ui.LaunchActivity
import com.example.testapp.ui.movie.MovieFragment

class LoginFragment : Fragment() {

    private val loginViewModel: LoginViewModel by viewModel()

    companion object {
        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mBinding: FragmentLoginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        login_btn.setOnClickListener {
            loginViewModel.authenticateUser(email.text.toString(), password.text.toString())
        }

        loginViewModel.isSuccess.observe(this, Observer {
            if (it) {
                // Get the text fragment instance
                val movieFragment = MovieFragment()

                // Get the support fragment manager instance
                val manager : FragmentManager? = fragmentManager

                // Begin the fragment transition using support fragment manager
                val transaction = manager?.beginTransaction()

                // Replace the fragment on container
                transaction?.replace(R.id.fragment_movie,movieFragment)
                //transaction?.addToBackStack(null)

                // Finishing the transition
                transaction?.commit()
            } else {
                //error
            }
        })
    }


}
