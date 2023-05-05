package fingerfire.com.nyanko.features.cats.di

import fingerfire.com.nyanko.features.cats.data.repository.CatRepository
import org.koin.dsl.module

class CatDataModules {

    fun getCatDataModules() = module {
        factory {
            CatRepository(get())
        }
    }
}