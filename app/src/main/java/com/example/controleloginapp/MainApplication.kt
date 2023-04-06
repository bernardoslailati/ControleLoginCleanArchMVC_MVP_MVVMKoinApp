package com.example.controleloginapp

import android.app.Application
import android.util.Log
import com.example.controleloginapp.data.model.Car
import com.example.controleloginapp.data.model.CarController
import com.example.controleloginapp.data.model.Engine
import com.example.controleloginapp.di.loginModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {
    
    override fun onCreate() {
        super.onCreate()
        
//        val engine = Engine(model = "EA111")
//        val car = Car(
//            model = "Gol 1.0 2013",
//            engine = engine
//        )
//        CarController.car = car
//        Log.d("testeDebug", "Application onCreate | CarController.car = car")
        
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(loginModule)
        }
    }
    
}