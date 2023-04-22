package com.example.presentation.controller

import com.example.domain.usecase.GetProfileUseCase
import com.example.domain.usecase.LoginUseCase
import com.example.presentation.databinding.ActivityLoginBinding
import com.example.presentation.ui.extension.showToast

class LoginController(
    val loginBinding: ActivityLoginBinding,
    private val getProfileUseCase: GetProfileUseCase,
    private val loginUseCase: LoginUseCase,
) {
    
    fun showProfile() {
        val profile = getProfileUseCase.execute()
        loginBinding.tvTitle.text = "Bem-vindo ${profile.name}!"
    }
    
    fun loginUser() {
        with(loginBinding) {
            val isLoggedIn = loginUseCase.execute(
                email = loginBinding.etEmail.text.toString(),
                password = loginBinding.etPassword.text.toString()
            )
            
            root.context.showToast(
                message = if (isLoggedIn)
                    "Redirecionando para tela de início..."
                else
                    "Falha ao logar usuário. Tente novamente."
            )
        }
    }
    
}