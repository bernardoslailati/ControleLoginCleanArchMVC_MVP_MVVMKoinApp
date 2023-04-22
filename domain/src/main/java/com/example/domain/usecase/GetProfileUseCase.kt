package com.example.domain.usecase

import com.example.domain.model.ProfileModel
import com.example.domain.repository.UserRepository
import com.example.domain.repository.UserRepositoryImpl
import com.example.domain.usecase.base.UseCase

class GetProfileUseCase(
    private val repository: UserRepository
) {
    
    fun execute(): ProfileModel {
        return repository.getProfile()
    }
    
}