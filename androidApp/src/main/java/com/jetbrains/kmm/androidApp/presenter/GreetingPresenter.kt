package com.jetbrains.kmm.androidApp.presenter

import com.jetbrains.kmm.shared.Greeting

class GreetingPresenter(private val greeting: Greeting) {
    fun sayHello() = greeting.sayHello()
}