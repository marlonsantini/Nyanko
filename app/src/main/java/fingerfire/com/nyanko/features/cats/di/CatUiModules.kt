package fingerfire.com.nyanko.features.cats.di

import fingerfire.com.nyanko.features.cats.ui.CatViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class CatUiModules {

    fun getViewModules() = module {
        viewModel {
            CatViewModel(get())
        }
    }
}