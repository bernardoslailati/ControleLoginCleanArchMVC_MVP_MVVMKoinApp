package com.example.presentation.ui.architecture.presenter.base

interface BasePresenter<T> {
    var view: T?
    fun attachView(view: T)
    fun detachView()
}