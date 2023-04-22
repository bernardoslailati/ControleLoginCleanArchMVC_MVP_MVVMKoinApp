package com.example.domain.repository

import com.example.data.datasources.UserLocalDataSource
import com.example.data.datasources.UserRemoteDataSource
import com.example.domain.mapper.toDomain
import com.example.domain.model.ProfileModel

class UserRepositoryImpl(
    private val userLocalDataSource: UserLocalDataSource,
    private val userRemoteDataSource: UserRemoteDataSource
): UserRepository {
    
    override fun login(email: String, password: String): Boolean {
        return userRemoteDataSource.login(email, password)
    }
    
    override fun getProfile(): ProfileModel {
        return userLocalDataSource.getProfile().toDomain()
    }
    
}