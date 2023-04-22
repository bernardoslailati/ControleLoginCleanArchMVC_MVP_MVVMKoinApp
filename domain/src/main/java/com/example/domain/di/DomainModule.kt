package com.example.domain.di

import com.example.data.di.dataModule
import com.example.domain.repository.UserRepository
import com.example.domain.repository.UserRepositoryImpl
import com.example.domain.usecase.GetProfileUseCase
import com.example.domain.usecase.LoginUseCase
import com.example.domain.usecase.base.UseCase
import org.koin.dsl.module

val domainModule = module {
    includes(dataModule)
    single<UserRepository> { UserRepositoryImpl(get(), get()) }
    single { GetProfileUseCase(get()) }
    single { LoginUseCase(get()) }
}