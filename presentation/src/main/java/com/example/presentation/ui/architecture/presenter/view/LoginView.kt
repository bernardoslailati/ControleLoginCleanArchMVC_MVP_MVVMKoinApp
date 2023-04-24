package com.example.presentation.ui.architecture.presenter.view

import com.example.domain.model.ProfileModel

interface LoginView {
    // login
    fun onLoginSuccess()
    fun onLoginError()
    
    // profile
    fun onProfileSuccess(profile: ProfileModel)
    fun onProfileError()
    
    fun showLoading()
    fun hideLoading()
}