package fingerfire.com.nyanko.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object SetupRetrofit {

    private const val BASE_URL = "https://api.thecatapi.com/v1/"
    const val API_KEY = "live_ZHOzq8t6ME445aS46NiG9D5hiiqmApafuyWqqD6HEIZhSpY6Uff60GHdL2Fassny"
    const val LIMIT = 10

    private fun client() = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}