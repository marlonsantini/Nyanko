package fingerfire.com.nyanko.api

import fingerfire.com.nyanko.features.cats.data.response.CatResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import fingerfire.com.nyanko.network.SetupRetrofit.API_KEY


interface CatApi {

    @Headers("x-api-key: $API_KEY")
    @GET("images/search/")
    suspend fun getCatPics(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): Response<List<CatResponse>>

}