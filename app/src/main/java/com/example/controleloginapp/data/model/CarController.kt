package com.example.controleloginapp.data.model

object CarController {
    
    // parâmetro
    lateinit var car: Car
    
    fun describeCar(): String {
        return car.model + " | " + car.engine.model
    }
    
}