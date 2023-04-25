package com.example.presentation.ui.architecture.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.model.ProfileModel
import com.example.domain.usecase.GetProfileUseCase
import com.example.domain.usecase.LoginUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel(
    private val getProfileUseCase: GetProfileUseCase,
    private val loginUseCase: LoginUseCase,
): ViewModel() {
    
    private val _isLoggedIn: MutableLiveData<Boolean> = MutableLiveData()
    val isLoggedIn: LiveData<Boolean> = _isLoggedIn
    
    private val _profile: MutableLiveData<ProfileModel> = MutableLiveData()
    val profile: LiveData<ProfileModel> = _profile
    
    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean> = _isLoading
    
    fun login(email: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            _isLoading.postValue(true)
            delay(2_000)
            _isLoggedIn.postValue(loginUseCase.execute(email, password))
            _isLoading.postValue(false)
        }
    }
    
    fun getProfile() {
        CoroutineScope(Dispatchers.IO).launch {
            _isLoading.postValue(true)
            delay(2_000)
            _profile.postValue(getProfileUseCase.execute())
            _isLoading.postValue(false)
        }
    }
    
}