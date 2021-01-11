package com.tutorial.machinetest.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Apiclient {
    //public static final String BASE_URL = "https://api-dev.serverlessbanking.com/";
    const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private var retrofit: Retrofit? = null

    /*        Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())*/
    val client: Retrofit?
        get() {
            if (retrofit == null) {
                val okHttpClient = OkHttpClient.Builder()
                        .connectTimeout(1, TimeUnit.MINUTES)
                        .readTimeout(30, TimeUnit.SECONDS)
                        .writeTimeout(15, TimeUnit.SECONDS)
                        .build()

                /*        Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())*/retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(NullOnEmptyConverterFactory())
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(okHttpClient)
                        .build()
            }
            return retrofit
        }
}