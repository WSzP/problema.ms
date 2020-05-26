package ms.problema.tgmuresproblema.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/18/2020
 *
 */

class RetrofitAdapter {

    val adapter: ms.problema.tgmuresproblema.api.endpoints.ReportEndpoints
    private val baseUrl = "https://problema.ms/api/"

    init {
        val okHttpClient = OkHttpClient.Builder()
            .build()

        adapter = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ms.problema.tgmuresproblema.api.endpoints.ReportEndpoints::class.java)

    }

}