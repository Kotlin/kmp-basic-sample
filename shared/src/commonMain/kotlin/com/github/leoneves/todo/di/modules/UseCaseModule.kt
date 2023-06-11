package com.github.leoneves.todo.di.modules

import com.github.leoneves.todo.domain.usecase.ListUsersUseCase
import org.koin.dsl.module

class UseCaseModule {

    fun provide() = module {
        single { ListUsersUseCase(get()) }
    }
}