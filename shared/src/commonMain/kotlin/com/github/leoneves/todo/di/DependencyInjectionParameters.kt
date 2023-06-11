package com.github.leoneves.todo.di

import com.github.leoneves.todo.data.DatabaseDriverFactory
import com.github.leoneves.todo.utils.KmmContext

data class DependencyInjectionParameters(
    val kmmContext: KmmContext,
    val databaseDriverFactory: DatabaseDriverFactory
)
