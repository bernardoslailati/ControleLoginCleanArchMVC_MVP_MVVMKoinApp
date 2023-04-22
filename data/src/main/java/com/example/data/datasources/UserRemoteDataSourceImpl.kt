package com.example.data.datasources

import com.example.data.network.LoginRetrofitService

class UserRemoteDataSourceImpl(
    private val loginRetrofitService: LoginRetrofitService
) : UserRemoteDataSource {
    
    override fun login(email: String, password: String): Boolean {
        return loginRetrofitService.login(email, password)
    }
    
}