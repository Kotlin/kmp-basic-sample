package com.jetbrains.kmm.androidApp

import android.app.Application
import com.jetbrains.kmm.androidApp.di.androidAppModule
import com.jetbrains.kmm.shared.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
//import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class KmmApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@KmmApplication)
            androidLogger(Level.DEBUG)
            modules(appModule() + androidAppModule)
        }
    }
}