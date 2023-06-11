package com.github.leoneves.todo.di.modules

import com.github.leoneves.todo.presentation.home.HomeViewModel
import org.koin.dsl.module

class ViewModelModule {

    fun provide() = module {
        single { HomeViewModel(get()) }
    }
}