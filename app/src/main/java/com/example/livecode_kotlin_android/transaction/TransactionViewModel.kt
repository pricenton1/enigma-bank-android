package com.example.livecode_kotlin_android.transaction

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.livecode_kotlin_android.config.RetrofitBuilder

class TransactionViewModel:ViewModel() {

    val transactionRepository:TransactionRepository

    init {
        val transactionAPI = RetrofitBuilder.createRetrofit().create(TransactionAPI::class.java)
        transactionRepository = TransactionRepository(transactionAPI)
    }

    val transaction : LiveData<Transaction> = transactionRepository.transaction
    val allTransaction : LiveData<List<Transaction>> = transactionRepository.allTransaction

    fun getTranactionByID(id:Int){
        transactionRepository.getTransactionByID(id)
    }

    fun createTransaction(transaction: Transaction){
        transactionRepository.createTransaction(transaction)
    }

    fun getAllTransaction() = transactionRepository.getAllTransaction()
}