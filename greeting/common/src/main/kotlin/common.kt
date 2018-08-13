package org.greeting

expect class Platform() {
    val platform: String
}

class Greeting {
    fun greeting(): String = "Hello, ${Platform().platform}"
    fun greetingCalc(): String = "Hello, ${Calculator.getName("a1")}"
}
