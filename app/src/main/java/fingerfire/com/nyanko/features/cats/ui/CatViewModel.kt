package fingerfire.com.nyanko.features.cats.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fingerfire.com.nyanko.features.cats.data.repository.CatRepository
import fingerfire.com.nyanko.features.cats.ui.viewstate.CatViewState
import fingerfire.com.nyanko.network.SetupRetrofit.LIMIT
import kotlinx.coroutines.launch

class CatViewModel(private val catRepository: CatRepository) : ViewModel() {

    private val catsMutableLiveData: MutableLiveData<CatViewState> =
        MutableLiveData<CatViewState>()

    val catLiveData: LiveData<CatViewState>
        get() {
            return catsMutableLiveData
        }

    fun getCatPics() {
        viewModelScope.launch {
            val catResponse = catRepository.loadCatPics(1, LIMIT)
            if(catResponse.isSuccessful && catResponse.body() != null) {
                catsMutableLiveData.postValue(CatViewState(sucess = catResponse.body()))
            } else if (catResponse.errorBody() != null) {
                catsMutableLiveData.postValue(CatViewState(failure = true))
            }
        }
    }

}