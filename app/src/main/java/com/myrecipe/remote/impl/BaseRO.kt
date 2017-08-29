package com.myrecipe.remote.impl

import com.myrecipe.common.BonConstants
import com.myrecipe.remote.components.RequestInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * base remote object
 * Created by sun on 2017/8/29.
 */
open class BaseRO<out T>(t: Class<T>) {

    private val retrofit by lazy {
        val okHttp = OkHttpClient.Builder()
                .addInterceptor(RequestInterceptor())
                .addInterceptor(HttpLoggingInterceptor().setLevel(if (BonConstants.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE))
                .build()
        Retrofit.Builder()
                .client(okHttp)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BonConstants.API_ROOT_URL)
                .build()
    }

    val api by lazy { retrofit.create(t) }
}