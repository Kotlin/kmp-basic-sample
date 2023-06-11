package com.github.leoneves.todo.di.modules

import com.github.leoneves.todo.data.auth.SecureTokenStorage
import com.github.leoneves.todo.utils.KmmContext
import org.koin.dsl.module

class StorageModule(private val kmmContext: KmmContext) {

    fun provide() = module {
        single { SecureTokenStorage(kmmContext) }
    }
}