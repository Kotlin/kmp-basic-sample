package com.jetbrains.basicsample

class Greeting {
    fun greeting(): String {
        return "Hello, ${getPlatform().platform}!"
    }
}
