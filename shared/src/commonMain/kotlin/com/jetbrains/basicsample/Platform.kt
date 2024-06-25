package com.jetbrains.basicsample

interface Platform {
    val platform: String
}

expect fun getPlatform(): Platform