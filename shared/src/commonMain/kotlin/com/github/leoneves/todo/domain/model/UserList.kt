package com.github.leoneves.todo.domain.model

data class UserList(
    val users: List<User>,
    val total: Long,
    val skip: Long,
    val limit: Long
)
