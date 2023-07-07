package com.jetbrains.kmm.shared.di

import org.koin.dsl.module
import com.jetbrains.kmm.shared.Platform
import org.koin.core.module.dsl.singleOf


val platformModule = module {
    singleOf(::Platform)
}