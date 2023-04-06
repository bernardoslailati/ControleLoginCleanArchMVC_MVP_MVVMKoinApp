package com.example.controleloginapp.service_locator

import com.example.controleloginapp.data.datasources.UserLocalDataSource
import com.example.controleloginapp.data.datasources.UserRemoteDataSource
import com.example.controleloginapp.data.network.LoginRetrofitService
import com.example.controleloginapp.data.repository.UserRepository

object AppContainer {
    
//    val loginRetrofitService = object : LoginRetrofitService {
//        override fun login(email: String, password: String): Boolean {
//            return true
//        }
//    }
//            Retrofit.Builder()
//            .baseUrl("https://my-backend.com")
//            .build()
//            .create(LoginRetrofitService::class.java)
    
//    val userRemoteDataSource = UserRemoteDataSource(
//        loginRetrofitService
//    )
//    val userLocalDataSource = UserLocalDataSource()
    
//    val userRepository = UserRepository(
//        userLocalDataSource, userRemoteDataSource
//    )
    
}