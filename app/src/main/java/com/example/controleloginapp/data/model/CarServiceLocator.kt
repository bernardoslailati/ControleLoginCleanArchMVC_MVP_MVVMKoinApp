package com.example.controleloginapp.data.model

// localizador de serviços
object CarServiceLocator {
    
    private val engine: Engine = Engine(model = "X")
    private val car: Car = Car(model = "Y", engine = engine)
    
    fun obtainEngine(): Engine = engine
    fun obtainCar(): Car = car
    
}