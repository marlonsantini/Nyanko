package fingerfire.com.nyanko.di

import fingerfire.com.nyanko.network.SetupRetrofit
import org.koin.dsl.module

class NetworkModules {

    fun getNetworkModules() = module {
        single {
            SetupRetrofit.getRetrofit()
        }
    }
}