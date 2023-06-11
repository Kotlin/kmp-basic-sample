package com.github.leoneves.todo.domain.dao

import com.github.leoneves.todo.domain.model.User

interface UserDAO {
    fun listUsers(): List<User>
    fun listUsersByName(name: String): List<User>
}
