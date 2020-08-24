package com.example.livecode_kotlin_android.user

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserAPI {

    @GET("logins")
    fun getUser():Call<User>

    @GET("login/{id}")
    fun getUserByID(@Path("id")id:Int): Call<User>


}