package com.example.livecode_kotlin_android.reycleAdapter

import android.view.LayoutInflater
import android.view.SurfaceControl
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.livecode_kotlin_android.R
import com.example.livecode_kotlin_android.transaction.Transaction
import kotlinx.android.synthetic.main.history_recycle_item_layout.view.*

class HistoryRecycleViewAdapter(private val transactionList:List<Transaction>) :RecyclerView.Adapter<HistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.history_recycle_item_layout,parent,false)
        return HistoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return transactionList.size
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.amount.text = transactionList[position].amount.toString()
        holder.date.text = transactionList[position].trans_date.toString()
    }
}

class HistoryViewHolder(v: View): RecyclerView.ViewHolder(v){

    val amount  = v.findViewById<TextView>(R.id.amount_text)
    val date = v.findViewById<TextView>(R.id.date_text)
    val imageHistory: ImageView = v.findViewById(R.id.image_history)
}