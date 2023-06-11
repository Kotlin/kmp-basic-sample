package com.github.leoneves.todo.di.modules

import com.github.leoneves.todo.data.network.TodoApi
import org.koin.dsl.module

class ApiModule {

    fun provide() = module {
        single { TodoApi(get()) }
    }
}