package com.example.tgmuresproblema.ui.base

import android.app.Application
import com.example.tgmuresproblema.koin.apiModule
import com.example.tgmuresproblema.koin.dataModule
import com.example.tgmuresproblema.koin.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/16/2020
 *
 */

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@BaseApplication)
            modules(
                listOf(
                    uiModule,
                    dataModule,
                    apiModule
                )
            )
        }
    }

}