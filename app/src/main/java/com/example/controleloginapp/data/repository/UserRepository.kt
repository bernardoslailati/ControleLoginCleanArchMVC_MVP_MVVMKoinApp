package com.example.controleloginapp.data.repository

import com.example.controleloginapp.data.datasources.UserLocalDataSource
import com.example.controleloginapp.data.datasources.UserRemoteDataSource
import com.example.controleloginapp.data.model.Profile

class UserRepository(
    private val userLocalDataSource: UserLocalDataSource,
    private val userRemoteDataSource: UserRemoteDataSource
) {
    
    fun login(email: String, password: String): Boolean {
        return userRemoteDataSource.login(email, password)
    }
    
    fun getProfile(): Profile {
        return userLocalDataSource.getProfile()
    }
    
}