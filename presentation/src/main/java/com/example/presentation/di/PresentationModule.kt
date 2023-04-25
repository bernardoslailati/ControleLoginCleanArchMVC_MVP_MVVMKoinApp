package com.example.presentation.di

import android.view.LayoutInflater
import com.example.domain.di.domainModule
import com.example.presentation.ui.architecture.controller.LoginController
import com.example.presentation.databinding.ActivityLoginBinding
import com.example.presentation.ui.architecture.presenter.LoginPresenterImpl
import com.example.presentation.ui.architecture.presenter.base.LoginPresenter
import com.example.presentation.ui.architecture.viewmodel.LoginViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    includes(domainModule)
    single { ActivityLoginBinding.inflate(LayoutInflater.from(androidContext())) }
    single { LoginViewModel(get(), get()) }
    single { LoginController(get(), get(), get()) }
    factory<LoginPresenter> { LoginPresenterImpl(get(), get()) }
    viewModel { LoginViewModel(get(), get()) }
}