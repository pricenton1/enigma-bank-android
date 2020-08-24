package com.example.livecode_kotlin_android.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.livecode_kotlin_android.config.RetrofitBuilder

class UserViewModel:ViewModel() {

    val userRepository:UserRepository


    init {
        val userAPI = RetrofitBuilder.createRetrofit().create(UserAPI::class.java)
        userRepository = UserRepository(userAPI)
    }

    val user : LiveData<List<User>> = userRepository.user

    fun getUser() = userRepository.getUser()
}