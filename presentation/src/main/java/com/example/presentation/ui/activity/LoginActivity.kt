package com.example.presentation.ui.activity

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.domain.model.ProfileModel
import com.example.presentation.ui.architecture.controller.LoginController
import com.example.presentation.databinding.ActivityLoginBinding
import com.example.presentation.ui.architecture.presenter.base.LoginPresenter
import com.example.presentation.ui.architecture.presenter.view.LoginView
import com.example.presentation.ui.architecture.viewmodel.LoginViewModel
import com.example.presentation.ui.extension.showToast
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity(), LoginView {
    
    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    
    private val loginViewModel: LoginViewModel by viewModel()

//    private val loginPresenter: LoginPresenter by inject()
    
    override fun onDestroy() {
//        loginPresenter.detachView()
        super.onDestroy()
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        loginPresenter.attachView(this)
        
        setupView()
        addObservers()
    }
    
    private fun addObservers() {
        loginViewModel.isLoggedIn.observe(this) { isLoggedIn ->
            isLoggedIn?.let {
                if (it)
                    showToast("Login efetuado com sucesso!")
                else
                    showToast("Falha ao efetuar login.")
            }
        }
    
        loginViewModel.profile.observe(this) { profile ->
            profile?.let {
                if (it.name.isNotEmpty())
                    binding.tvTitle.text = "Bem-vindo ${profile.name}!"
                else
                    showToast("Nenhum perfil de usuário armazenado.")
            }
        }
    
        loginViewModel.isLoading.observe(this) { isLoading ->
            isLoading?.let {
                if (it)
                    binding.pbLoading.visibility = View.VISIBLE
                else
                    binding.pbLoading.visibility = View.GONE
            }
        }
    }
    
    private fun setupView() {
        with(binding) {
//            loginPresenter.getProfile()
            loginViewModel.getProfile()
            
            btnLogin.setOnClickListener {
//                loginPresenter.login(
//                    email = etEmail.text.toString(),
//                    password = etPassword.text.toString()
//                )
                loginViewModel.login(
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