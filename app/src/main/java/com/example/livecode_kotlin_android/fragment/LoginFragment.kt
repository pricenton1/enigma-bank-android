package com.example.livecode_kotlin_android.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.livecode_kotlin_android.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(),View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submitLogin.setOnClickListener(this)
        val username = usenameInputText.text.toString()
    }

    override fun onClick(v: View?) {
        when(v){
            submitLogin -> {
                if(usenameInputText.text.toString() == "admin" && passwordInputText.text.toString() == "admin"){
                    Navigation.findNavController(submitLogin).navigate(R.id.action_loginFragment_to_homeFragment)
                }else{
                    makeText(this.context, "Invalid Login", LENGTH_SHORT).show()
                }

            }
        }
    }

}