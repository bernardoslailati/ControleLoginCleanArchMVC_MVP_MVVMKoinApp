package com.example.presentation.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.presentation.ui.architecture.controller.LoginController
import com.example.presentation.databinding.ActivityLoginBinding
import com.example.presentation.ui.extension.showToast
import org.koin.android.ext.android.inject

class LoginActivity : AppCompatActivity() {
    
    private val loginController: LoginController by inject()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(loginController.loginBinding.root)
        
        setupView()
    }
    
    private fun setupView() {
        with(loginController.loginBinding) {
            loginController.showProfile()
            
            btnLogin.setOnClickListener {
//                val isSuccess: Boolean = loginViewModel.login(
//                    email = etEmail.text.toString(),
//                    password = etPassword.text.toString()
//                )
//
//                this@LoginActivity.toast(
//                    message =
//                        if (isSuccess)
//                            "Login efetuado com sucesso!"
//                        else
//                            "Falha ao efetuar o login."
//                )
                
                loginController.loginUser()
            }
        }
    }
}