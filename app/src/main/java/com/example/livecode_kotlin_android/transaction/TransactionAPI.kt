package com.example.livecode_kotlin_android.transaction

import com.example.livecode_kotlin_android.user.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TransactionAPI {

    @GET("transactions")
    fun getAllTransaction():Call<Transaction>

    @GET("transaction/{id}")
    fun getTransactionByID(@Path("id")id:Int): Call<Transaction>

    @POST("transaction/add")
    fun createTransaction(@Body transaction: Transaction): Call<Transaction>
}