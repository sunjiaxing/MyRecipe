package com.myrecipe.remote.components

import com.myrecipe.common.BonConstants
import com.myrecipe.remote.IParams
import okhttp3.Interceptor
import okhttp3.Response

/**
 * 网络请求拦截器 （添加token等信息）
 * Created by sun on 2017/8/29.
 */
class RequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
                .newBuilder()
                .addHeader(IParams.AUTHORIZATION, "APPCODE ${BonConstants.APP_CODE}")
                .build()
        return chain.proceed(request)
    }
}