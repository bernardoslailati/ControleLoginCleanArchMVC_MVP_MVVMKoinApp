package com.example.presentation.ui.architecture.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.ProfileModel
import com.example.domain.usecase.GetProfileUseCase
import com.example.domain.usecase.LoginUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val getProfileUseCase: GetProfileUseCase,
    private val loginUseCase: LoginUseCase,
) : ViewModel() {
    
    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean> = _isLoading
    
    private val _profile: MutableLiveData<ProfileModel> = MutableLiveData()
    val profile: LiveData<ProfileModel> = _profile

//    private val _isLoggedIn: MutableLiveData<Boolean> = MutableLiveData()
//    val isLoggedIn: LiveData<Boolean> = _isLoggedIn

//    private val _isLoggedIn: MutableStateFlow<Boolean?> = MutableStateFlow(null)  //  ===> StateFlow: possui sempre um valor inicial, só
//    val isLoggedIn: StateFlow<Boolean?> = _isLoggedIn                             //       coleta o estado do novo valor recebido se o atual emitido
    //       for diferente do último valor coletado
    
    private val _isLoggedIn: MutableSharedFlow<Boolean> =
        MutableSharedFlow()       //  ===> SharedFlow: não possui um valor inicial, envia novos estados a serem coletados a cada
    val isLoggedIn: SharedFlow<Boolean> =
        _isLoggedIn                               //      emissão feita, mesmo que o valor atual seja IGUAL ao último valor emitido


//    fun login(email: String, password: String) {
//        viewModelScope.launch {
//            delay(2_000)
//            _isLoggedIn.postValue(loginUseCase.execute(email, password))
//            _profile.postValue(
//                ProfileModel(
//                    name = "Bernardo",
//                    email = "",
//                    password = ""
//                )
//            )
//        }
//    }
    
    fun login(email: String, password: String) {
        viewModelScope.launch {
            _isLoading.postValue(true)
            delay(2_000)
            val isLoggedIn = loginUseCase.execute(email, password)
            _isLoggedIn.emit(isLoggedIn)
            _profile.postValue(
                ProfileModel(
                    name = if (isLoggedIn) "Aluno" else "ERRO",
                    email = "",
                    password = ""
                )
            )
            _isLoading.postValue(false)
        }
    }
    
    
    fun getProfile() {
        viewModelScope.launch {
            _isLoading.postValue(true)
            delay(2_000)
            _profile.postValue(getProfileUseCase.execute())
            _isLoading.postValue(false)
        }
    }
}