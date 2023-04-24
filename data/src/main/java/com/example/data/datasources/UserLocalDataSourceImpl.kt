package com.example.data.datasources

import android.content.Context
import com.example.data.model.ProfileLocalModel


class UserLocalDataSourceImpl(context: Context): UserLocalDataSource {
    
    // acessar SharedPreferences...
    
    override fun getProfile() : ProfileLocalModel {
        return ProfileLocalModel("", "teste", "123")
    }

}