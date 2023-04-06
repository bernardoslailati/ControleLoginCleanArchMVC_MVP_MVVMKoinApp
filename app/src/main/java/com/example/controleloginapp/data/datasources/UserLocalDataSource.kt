package com.example.controleloginapp.data.datasources

import android.content.Context
import com.example.controleloginapp.data.model.Profile


class UserLocalDataSource(context: Context) {
    
    // acessar SharedPreferences...
    
    fun getProfile() : Profile {
        return Profile("", "", "")
    }

}