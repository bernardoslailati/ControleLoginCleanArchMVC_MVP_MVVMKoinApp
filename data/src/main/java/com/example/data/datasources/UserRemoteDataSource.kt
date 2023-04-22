package com.example.data.datasources

interface UserRemoteDataSource {
    
    fun login(email: String, password: String): Boolean
    
}