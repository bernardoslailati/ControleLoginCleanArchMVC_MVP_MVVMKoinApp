package com.example.presentation.ui.architecture.presenter.base

import com.example.presentation.ui.architecture.presenter.view.LoginView

interface LoginPresenter: BasePresenter<LoginView> {
    fun login(email: String, password: String)
    fun getProfile()
    override fun attachView(view: LoginView) {
        this.view = view
    }
    override fun detachView() {
        this.view = null
    }
}