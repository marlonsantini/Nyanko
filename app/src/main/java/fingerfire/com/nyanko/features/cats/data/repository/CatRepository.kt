package fingerfire.com.nyanko.features.cats.data.repository

import fingerfire.com.nyanko.api.CatApi
import fingerfire.com.nyanko.features.cats.data.response.CatResponse
import fingerfire.com.nyanko.network.SetupRetrofit
import retrofit2.Response

class CatRepository(private val catApi: CatApi) {

    suspend fun loadCatPics(page: Int, limit: Int): Response<List<CatResponse>> {
        return catApi.getCatPics(page, limit)
    }
}