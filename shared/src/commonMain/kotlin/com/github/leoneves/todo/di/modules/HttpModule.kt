package com.github.leoneves.todo.di.modules

import com.github.leoneves.todo.data.network.DummyHttpClient
import org.koin.dsl.module

class HttpModule {

    fun provide() = module {
        single { DummyHttpClient.getHttpClient() }
    }
}
