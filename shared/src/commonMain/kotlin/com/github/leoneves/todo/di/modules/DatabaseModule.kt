package com.github.leoneves.todo.di.modules

import com.github.leoneves.todo.data.AppDatabase
import com.github.leoneves.todo.data.DatabaseDriverFactory
import com.github.leoneves.todo.data.dao.TodoDAOImpl
import com.github.leoneves.todo.data.dao.UserDAOImpl
import com.github.leoneves.todo.data.network.TodoApi
import com.github.leoneves.todo.domain.dao.TodoDAO
import com.github.leoneves.todo.domain.dao.UserDAO
import org.koin.dsl.module

class DatabaseModule(private val databaseDriverFactory: DatabaseDriverFactory) {

    fun provide() = module {
        single { AppDatabase(databaseDriverFactory.createDriver()) }
        factory<TodoDAO> { TodoDAOImpl(get()) }
        factory<UserDAO> { UserDAOImpl(get()) }
    }
}