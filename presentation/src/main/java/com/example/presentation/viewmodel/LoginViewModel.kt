package com.example.presentation.viewmodel

import com.example.domain.model.ProfileModel
import com.example.domain.usecase.GetProfileUseCase
import com.example.domain.usecase.LoginUseCase

class LoginViewModel(
    private val getProfileUseCase: GetProfileUseCase,
    private val loginUseCase: LoginUseCase,
) {
    
    fun login(email: String, password: String): Boolean =
        loginUseCase.execute(email, password)
    
    fun getProfile(): ProfileModel =
        getProfileUseCase.execute()
    
}