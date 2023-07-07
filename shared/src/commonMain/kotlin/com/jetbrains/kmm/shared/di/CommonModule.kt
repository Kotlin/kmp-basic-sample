package com.jetbrains.kmm.shared.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import com.jetbrains.kmm.shared.Greeting

val commonModule = module {
    singleOf(::Greeting)
}