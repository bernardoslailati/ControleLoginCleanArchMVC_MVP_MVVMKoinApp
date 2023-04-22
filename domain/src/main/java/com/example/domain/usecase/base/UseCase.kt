package com.example.domain.usecase.base

abstract class UseCase<in Params, out Result> {
    
    abstract fun execute(params: Params): Result
    
}