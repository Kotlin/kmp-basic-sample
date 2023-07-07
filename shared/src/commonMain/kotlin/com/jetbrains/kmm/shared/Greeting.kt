package com.jetbrains.kmm.shared

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }

    fun sayHello():String{
        return "Hello ${Platform().newVal}"
    }
}
