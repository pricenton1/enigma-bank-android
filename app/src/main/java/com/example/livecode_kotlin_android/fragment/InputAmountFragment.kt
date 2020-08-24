package com.example.livecode_kotlin_android.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.SurfaceControl
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.livecode_kotlin_android.R
import com.example.livecode_kotlin_android.transaction.Transaction
import com.example.livecode_kotlin_android.transaction.TransactionViewModel
import kotlinx.android.synthetic.main.fragment_input_amount.*
import java.util.*


class InputAmountFragment : Fragment(),View.OnClickListener {

    val transactionViewModel by activityViewModels<TransactionViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        confirm_button.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when(v){
            confirm_button -> {
                val sendTo = arguments?.getString("sendTo")
                val newSendTo = sendTo.toString()
                val bank = arguments?.getString("bank")
                val amount = amountInputText.text.toString()!!
                val amountInt = amount.toInt()!!
                val desc = descInputText.text.toString()

                val transaction = Transaction(destination = newSendTo,amount = amountInt,description = desc,trans_date = Date())
                transactionViewModel.createTransaction(transaction)

                Navigation.findNavController(confirm_button).navigate(R.id.action_inputAmountFragment_to_confirmationFragment)
            }
        }
    }

}