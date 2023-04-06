package com.example.controleloginapp.di

import com.example.controleloginapp.data.datasources.UserLocalDataSource
import com.example.controleloginapp.data.datasources.UserRemoteDataSource
import com.example.controleloginapp.data.network.LoginRetrofitService
import com.example.controleloginapp.data.repository.UserRepository
import com.example.controleloginapp.viewmodel.LoginViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val loginModule = module {
    single<LoginRetrofitService> {
        object : LoginRetrofitService {
            override fun login(email: String, password: String): Boolean {
                return false
            }
        }
    }
    single { UserRemoteDataSource(get()) }
    single { UserLocalDataSource(androidContext()) }
    single { UserRepository(get(), get()) }
    factory { LoginViewModel(get()) }
}