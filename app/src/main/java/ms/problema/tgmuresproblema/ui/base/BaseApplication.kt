package ms.problema.tgmuresproblema.ui.base

import android.app.Application
import ms.problema.tgmuresproblema.koin.apiModule
import ms.problema.tgmuresproblema.koin.dataModule
import ms.problema.tgmuresproblema.koin.uiModule
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