package com.example.nss_iitpatna.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.nss_iitpatna.R

class SignInFragment : Fragment() {

    companion object {
        fun newInstance() = SignInFragment()
    }

    private lateinit var viewModel: SignInViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)
        viewModel = ViewModelProvider(this).get(SignInViewModel::class.java)

        val navigateToSignUp: TextView = view.findViewById(R.id.navigate_to_sign_up)
        navigateToSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_nav_sign_in_to_nav_sign_up)
        }
        return view
    }
}