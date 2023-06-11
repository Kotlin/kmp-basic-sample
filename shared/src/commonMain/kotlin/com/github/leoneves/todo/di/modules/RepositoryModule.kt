package com.github.leoneves.todo.di.modules

import com.github.leoneves.todo.data.network.TodoApi
import com.github.leoneves.todo.data.repository.TodoRepositoryImpl
import com.github.leoneves.todo.domain.repository.TodoRepository
import org.koin.dsl.module

class RepositoryModule {

    fun provide() = module {
        single<TodoRepository> { TodoRepositoryImpl(get(), get()) }
    }
}