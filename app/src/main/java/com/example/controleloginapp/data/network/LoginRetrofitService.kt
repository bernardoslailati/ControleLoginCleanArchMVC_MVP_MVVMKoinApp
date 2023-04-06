package com.example.controleloginapp.data.network

import retrofit2.http.GET

interface LoginRetrofitService {
    
    @GET("login")
    fun login(email: String, password: String): Boolean
    
}