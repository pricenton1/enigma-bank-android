package com.example.livecode_kotlin_android.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.livecode_kotlin_android.R
import com.example.livecode_kotlin_android.reycleAdapter.HistoryRecycleViewAdapter
import com.example.livecode_kotlin_android.transaction.TransactionViewModel
import kotlinx.android.synthetic.main.fragment_history.*

class HistoryFragment : Fragment() {

    private val transactionViewModel by activityViewModels<TransactionViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        history_recycle_view.layoutManager = LinearLayoutManager(activity)

        transactionViewModel.allTransaction.observe(viewLifecycleOwner, androidx.lifecycle.Observer{
            history_recycle_view.adapter = HistoryRecycleViewAdapter(it)
        })
        transactionViewModel.getAllTransaction()

    }
}