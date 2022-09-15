package com.br.apptest

import android.app.Application
import com.picpay.desafio.android.serviceModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppTestApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@AppTestApplication)
            modules(listOf(serviceModule))
        }
    }
}

