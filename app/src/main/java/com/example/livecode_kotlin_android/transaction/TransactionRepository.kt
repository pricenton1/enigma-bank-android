package com.example.livecode_kotlin_android.transaction

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.JsonArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TransactionRepository(val transactionAPI: TransactionAPI) {

    var transaction: MutableLiveData<Transaction> = MutableLiveData<Transaction>()

    var allTransaction: MutableLiveData<List<Transaction>> = MutableLiveData<List<Transaction>>()

    fun getAllTransaction(){
        transactionAPI.getAllTransaction().enqueue(object : Callback<Transaction> {
            override fun onFailure(call: Call<Transaction>, t: Throwable) {
                println(t.localizedMessage)
            }

            override fun onResponse(call: Call<Transaction>, response: Response<Transaction>) {
                val response = response.body()
                println("RESPON $response")
                val gson = Gson()
                val stringResponse = gson.toJson(response)
                println(stringResponse)
                val movieObject:List<Transaction> = gson.fromJson(stringResponse,Array<Transaction>::class.java).toList()
                allTransaction.value = movieObject

            }

        })
    }

    fun getTransactionByID(id:Int){
        transactionAPI.getTransactionByID(id).enqueue(object : Callback<Transaction> {

            override fun onFailure(call: Call<Transaction>, t: Throwable) {
                println(t.localizedMessage)
            }

            override fun onResponse(call: Call<Transaction>, response: Response<Transaction>) {
                val responseData = response.body()
                val res = responseData
                val gson = Gson()
                transaction.value = gson.fromJson(gson.toJson(res), Transaction::class.java)
            }

        })
    }

    fun createTransaction(transaction: Transaction){
        transactionAPI.createTransaction(transaction).enqueue(object :Callback<Transaction>{
            override fun onFailure(call: Call<Transaction>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<Transaction>, response: Response<Transaction>) {
                println(response.isSuccessful)
                println("MASUK RESPONSE")
            }

        })
    }
}