package com.github.leoneves.todo.domain.model

data class Todo(
    val id: Long,
    val todo: String,
    val completed: Boolean,
    val userId: Long
)
