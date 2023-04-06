package com.example.controleloginapp.data.datasources

import com.example.controleloginapp.data.network.LoginRetrofitService

class UserRemoteDataSource(
    private val loginRetrofitService: LoginRetrofitService
) {
    
    fun login(email: String, password: String): Boolean {
        return loginRetrofitService.login(email, password)
    }
    
}