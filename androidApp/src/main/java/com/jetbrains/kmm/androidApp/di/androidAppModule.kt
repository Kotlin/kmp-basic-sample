package com.jetbrains.kmm.androidApp.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import com.jetbrains.kmm.androidApp.presenter.GreetingPresenter

val androidAppModule = module {
    singleOf(::GreetingPresenter)
}