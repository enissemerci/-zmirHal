package semerci.enis.toptanc.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://acikveri.bizizmir.com/tr/api/3/action/"

    val apiService: HalApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HalApiService::class.java)
    }
}