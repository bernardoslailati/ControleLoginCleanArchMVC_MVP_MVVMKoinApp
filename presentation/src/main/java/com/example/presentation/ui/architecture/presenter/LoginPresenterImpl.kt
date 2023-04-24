package com.example.presentation.ui.architecture.presenter

import com.example.domain.model.ProfileModel
import com.example.domain.usecase.GetProfileUseCase
import com.example.domain.usecase.LoginUseCase
import com.example.presentation.ui.architecture.presenter.base.LoginPresenter
import com.example.presentation.ui.architecture.presenter.view.LoginView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginPresenterImpl(
    private val loginUseCase: LoginUseCase,
    private val getProfileUseCase: GetProfileUseCase,
) : LoginPresenter {
    
    override var view: LoginView? = null
    
    override fun login(email: String, password: String) {
        // 1º) mostrar o loading
        // 2º) executar o login (useCase)
        // 3º) quando receber a resposta do login:
        //      i. parar o loading
        //      ii. se sucesso, mostrar mensagem de sucesso
        //      iii. em caso de erro, mostrar mensagem de erro
        view?.let {
            it.showLoading()
            CoroutineScope(Dispatchers.IO).launch(Dispatchers.Main) {
                delay(2_000)
                val isLoggedIn = loginUseCase.execute(email, password)
                it.hideLoading()
                if (isLoggedIn)
                    it.onLoginSuccess()
                else
                    it.onLoginError()
            }
        }
    }
    
    override fun getProfile() {
        // 1º) buscar o perfil do usuário (usecase)
        //      i. caso o nome do usuário estiver vazio, mostrar mensagem de erro
        //      ii. caso o nome do usuário estiver preenchido, mostrá-la junto ao texto de bem-vindo
        view?.let {
            val profile: ProfileModel = getProfileUseCase.execute()
            if (profile.name.isNotEmpty())
                it.onProfileSuccess(profile)
            else
                it.onProfileError()
        }
    }
}
