package com.github.leoneves.todo.data

import com.github.leoneves.todo.data.dao.TodoDAOImpl
import com.github.leoneves.todo.data.dao.UserDAOImpl
import com.github.leoneves.todo.domain.dao.TodoDAO
import com.github.leoneves.todo.domain.dao.UserDAO

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    val todoDAO: TodoDAO = TodoDAOImpl(database)
    val userDAO: UserDAO = UserDAOImpl(database)
}