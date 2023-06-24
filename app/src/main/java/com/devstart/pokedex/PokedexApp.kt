package com.devstart.pokedex

import android.app.Application
import com.devstart.pokedex.data.di.dataModule
import com.devstart.pokedex.domain.di.domainModule
import com.devstart.pokedex.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class PokedexApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@PokedexApp)
            modules(
                domainModule,
                presentationModule,
                dataModule
            )
        }
    }
}