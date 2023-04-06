package com.example.controleloginapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.controleloginapp.data.datasources.UserLocalDataSource
import com.example.controleloginapp.data.datasources.UserRemoteDataSource
import com.example.controleloginapp.data.network.LoginRetrofitService
import com.example.controleloginapp.data.repository.UserRepository
import com.example.controleloginapp.databinding.ActivityMainBinding
//import com.example.controleloginapp.service_locator.AppContainer.userRepository
import com.example.controleloginapp.ui.extension.toast
import com.example.controleloginapp.viewmodel.LoginViewModel
import org.koin.android.ext.android.inject
import retrofit2.Retrofit

class LoginActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    
    private val loginViewModel: LoginViewModel by inject()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        
        setupView()
    }
    
    private fun setupView() {
        with(binding) {
            btnLogin.setOnClickListener {
                val isSuccess: Boolean = loginViewModel.login(
                    email = etEmail.text.toString(),
                    password = etPassword.text.toString()
                )
                
                this@LoginActivity.toast(
                    message =
                        if (isSuccess)
                            "Login efetuado com sucesso!"
                        else
                            "Falha ao efetuar o login."
                )
            }
        }
    }
}