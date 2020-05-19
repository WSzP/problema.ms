package com.example.tgmuresproblema.api

import com.example.tgmuresproblema.api.endpoints.ReportEndpoints
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

    val adapter: ReportEndpoints
    private val baseUrl = "https://problema.ms/api/"

    init {
        val okHttpClient = OkHttpClient.Builder()
            .build()

        adapter = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ReportEndpoints::class.java)

    }

}