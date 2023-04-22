package com.example.domain.repository

import com.example.domain.model.ProfileModel

interface UserRepository {
    
    fun login(email: String, password: String): Boolean
    
    fun getProfile(): ProfileModel
    
}