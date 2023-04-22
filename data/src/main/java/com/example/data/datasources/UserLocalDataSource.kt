package com.example.data.datasources

import com.example.data.model.ProfileLocalModel

interface UserLocalDataSource {
    fun getProfile() : ProfileLocalModel
}