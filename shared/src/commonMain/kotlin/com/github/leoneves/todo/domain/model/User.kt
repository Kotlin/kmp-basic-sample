package com.github.leoneves.todo.domain.model

data class User(
    val id: Long,
    val firstName: String,
    val email: String,
    val phone: String,
    val lastName: String,
    val maidenName: String
)
