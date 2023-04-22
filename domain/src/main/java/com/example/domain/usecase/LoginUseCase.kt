package com.example.domain.usecase

import com.example.domain.repository.UserRepository

class LoginUseCase(
    private val repository: UserRepository
) {
    
    fun execute(email: String, password: String): Boolean {
        return repository.login(email, password)
    }
    
}