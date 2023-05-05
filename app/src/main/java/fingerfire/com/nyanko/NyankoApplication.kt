package fingerfire.com.nyanko

import android.app.Application
import fingerfire.com.nyanko.di.ApiModules
import fingerfire.com.nyanko.di.NetworkModules
import fingerfire.com.nyanko.features.cats.di.CatDataModules
import fingerfire.com.nyanko.features.cats.di.CatUiModules
import org.koin.core.context.startKoin

class NyankoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(
                    NetworkModules().getNetworkModules(),
                    CatUiModules().getViewModules(),
                    CatDataModules().getCatDataModules(),
                    ApiModules().getApiModules()
                )
            )
        }
    }
}