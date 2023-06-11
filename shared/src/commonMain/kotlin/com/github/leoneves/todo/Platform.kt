package com.github.leoneves.todo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform