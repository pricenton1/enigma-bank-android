package com.example.livecode_kotlin_android.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.livecode_kotlin_android.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.history_recycle_item_layout.*

class HomeFragment : Fragment(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        transfer_button.setOnClickListener(this)
        history_button.setOnClickListener(this)
        call_button.setOnClickListener(this)
        amountText.text = 500.toString()
    }

    override fun onClick(v: View?) {
        when(v){
            transfer_button -> {
                Navigation.findNavController(transfer_button).navigate(R.id.action_homeFragment_to_inputBankFragment)
            }
            history_button -> {
                Navigation.findNavController(history_button).navigate(R.id.action_homeFragment_to_historyFragment)
            }
            call_button -> {

            }
            else -> {
                println("ERROR")
            }
        }
    }

}