package com.example.controleloginapp.viewmodel

import com.example.controleloginapp.data.model.Profile
import com.example.controleloginapp.data.repository.UserRepository

class LoginViewModel(
    private val userRepository: UserRepository
) {
    
    fun login(email: String, password: String) : Boolean {
        return userRepository.login(email, password)
    }
    
    fun getProfile(): Profile {
        return userRepository.getProfile()
    }
    
}