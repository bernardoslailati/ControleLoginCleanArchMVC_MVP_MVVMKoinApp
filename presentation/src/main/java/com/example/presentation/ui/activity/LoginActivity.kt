package com.example.presentation.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.domain.model.ProfileModel
import com.example.presentation.ui.architecture.controller.LoginController
import com.example.presentation.databinding.ActivityLoginBinding
import com.example.presentation.ui.architecture.presenter.base.LoginPresenter
import com.example.presentation.ui.architecture.presenter.view.LoginView
import com.example.presentation.ui.extension.showToast
import org.koin.android.ext.android.inject

class LoginActivity : AppCompatActivity(), LoginView {
    
    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    
    private val loginPresenter: LoginPresenter by inject()
    
    override fun onDestroy() {
        loginPresenter.detachView()
        super.onDestroy()
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loginPresenter.attachView(this)
        
        setupView()
    }
    
    private fun setupView() {
        with(binding) {
            loginPresenter.getProfile()
            
            btnLogin.setOnClickListener {
                loginPresenter.login(
                    email = etEmail.text.toString(),
                    password = etPassword.text.toString()
                )
            }
        }
    }
    
    override fun onLoginSuccess() {
        showToast("Login efetuado com sucesso!")
    }
    
    override fun onLoginError() {
        showToast("Falha ao efetuar login.")
    }
    
    override fun onProfileSuccess(profile: ProfileModel) {
        binding.tvTitle.text = "Bem-vindo ${profile.name}!"
    }
    
    override fun onProfileError() {
        showToast("Nenhum perfil de usuário armazenado.")
    }
    
    override fun showLoading() {
        binding.pbLoading.visibility = View.VISIBLE
    }
    
    override fun hideLoading() {
        binding.pbLoading.visibility = View.GONE
    }
}