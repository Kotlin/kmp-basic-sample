package com.github.leoneves.todo.data.auth

data class AuthToken(
    val token: String,
    val userId: Long,
    val name: String,
    val username: String
)