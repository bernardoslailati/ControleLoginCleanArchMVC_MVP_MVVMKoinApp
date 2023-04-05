package com.example.controleloginapp

import android.app.Application
import com.example.controleloginapp.data.Car
import com.example.controleloginapp.data.Engine

class MainApplication: Application() {
    
    override fun onCreate() {
        super.onCreate()
        
        Car.engine = Engine()
        
    }
    
}