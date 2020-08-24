package com.example.livecode_kotlin_android.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.example.livecode_kotlin_android.R
import kotlinx.android.synthetic.main.fragment_input_bank.*

class InputBankFragment : Fragment(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_bank, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        next_button.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when(v){
            next_button -> {
                val bundle = bundleOf(
                    Pair("sendTo", sendInputText.text.toString()),
                    Pair("bank", bankInputText.text.toString())
                )
                Navigation.findNavController(next_button).navigate(R.id.action_inputBankFragment_to_inputAmountFragment,bundle)
            }
        }
    }

}