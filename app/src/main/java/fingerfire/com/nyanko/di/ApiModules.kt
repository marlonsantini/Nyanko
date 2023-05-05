package fingerfire.com.nyanko.di

import fingerfire.com.nyanko.api.CatApi
import org.koin.dsl.module
import retrofit2.Retrofit

class ApiModules {

    fun getApiModules() = module {
        factory<CatApi> {
            get<Retrofit>().create(CatApi::class.java)
        }
    }
}