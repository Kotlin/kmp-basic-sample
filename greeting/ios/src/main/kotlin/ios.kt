package org.greeting

import platform.posix.*
import kotlinx.cinterop.*

actual class Platform actual constructor() {
    actual val platform: String = "iOS"
}

actual class Product(actual val user: String) {
    val model: String = memScoped {
        val systemInfo = alloc<utsname>()
        uname(systemInfo.ptr)
        systemInfo.machine.toKString()
    }

    fun iosSpecificOperation() {
        println("I am $model")
    }

    override fun toString() = "iOS product for $model"
}

actual object Factory {
    actual fun create(config: Map<String, String>) =
            Product(config["user"]!!)
    actual val platform: String = "ios"
}