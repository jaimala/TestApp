package com.example.testapp.ui.login


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import com.example.testapp.R
import com.example.testapp.ui.movie.MovieFragment
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel

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
            loginViewModel.authenticateUser(email.toString(), password.toString())
        }

        loginViewModel.responseStatus.observe(viewLifecycleOwner, Observer {
            if (it as Boolean) {
                callFragment()
            }
            else {
                val builder = AlertDialog.Builder(this)
                //set title for alert dialog
                builder.setTitle(R.string.dialogTitle)
                //set message for alert dialog
                builder.setMessage(R.string.dialogMessage)
                builder.setIcon(android.R.drawable.ic_dialog_alert)

                //performing cancel action
                builder.setNeutralButton("Cancel"){dialogInterface , which ->
                    Toast.makeText(context,"Login Failed",Toast.LENGTH_LONG).show()
                }

                // Create the AlertDialog
                val alertDialog: AlertDialog = builder.create()
                // Set other dialog properties
                alertDialog.setCancelable(false)
                alertDialog.show()
            }
        })
    }

    fun callFragment(){
        // Get the text fragment instance
        val movieFragment = MovieFragment()

        // Get the support fragment manager instance
        val manager : FragmentManager? = fragmentManager

        // Begin the fragment transition using support fragment manager
        val transaction = manager?.beginTransaction()

        // Replace the fragment on container
        transaction?.replace(R.id.container,movieFragment)
        //transaction?.addToBackStack(null)

        // Finishing the transition
        transaction?.commit()
    }


}
