package com.example.livecode_kotlin_android.user

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(private val userAPI: UserAPI) {

    var user: MutableLiveData<List<User>> = MutableLiveData<List<User>>()

    fun getUser(){
        userAPI.getUser().enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
                println(t.localizedMessage)
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                val response = response.body()
                val gson = Gson()
                val stringResponse = gson.toJson(response)
                val movieObject:List<User> = gson.fromJson(stringResponse,Array<User>::class.java).toList()
                user.value = movieObject
                println(user.value)
            }

        })
    }
}