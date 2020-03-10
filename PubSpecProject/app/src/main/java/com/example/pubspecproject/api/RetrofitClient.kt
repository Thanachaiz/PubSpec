package com.example.pubspecproject.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Headers
import java.util.concurrent.TimeUnit

object RetrofitClient {

    var retrofit: Retrofit? = null
    fun getClient(baseUrl: String): Retrofit? {
        if (retrofit == null) {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.HEADERS
            interceptor.level = HttpLoggingInterceptor.Level.BODY

//            val client = OkHttpClient.Builder()
//                .addNetworkInterceptor { chain ->
//                    val request = chain.request().newBuilder().addHeader("Connection", "close").build()
//                    chain.proceed(request)
//                }
//                .addInterceptor(interceptor)
//                .connectTimeout(100, TimeUnit.SECONDS)
//                .readTimeout(100, TimeUnit.SECONDS)
//                .addInterceptor(SupportInterceptor())
//                .build()

            retrofit = Retrofit.Builder()
//                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
        return retrofit
    }
}