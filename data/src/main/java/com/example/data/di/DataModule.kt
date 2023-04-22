package com.example.data.di

import com.example.data.datasources.UserLocalDataSource
import com.example.data.datasources.UserLocalDataSourceImpl
import com.example.data.datasources.UserRemoteDataSource
import com.example.data.datasources.UserRemoteDataSourceImpl
import com.example.data.network.LoginRetrofitService
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single<LoginRetrofitService> {
        
        val registeredUsers: HashMap<String, String> = hashMapOf(
            "teste@teste.com" to "123",
            "teste2@teste.com" to "456"
        )
        
        object : LoginRetrofitService {
            override fun login(email: String, password: String): Boolean {
                return registeredUsers.any { it.key == email && it.value == password }
            }
        }
    }
    single<UserRemoteDataSource> { UserRemoteDataSourceImpl(get()) }
    single<UserLocalDataSource> { UserLocalDataSourceImpl(androidContext()) }
}