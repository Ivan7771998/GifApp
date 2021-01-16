package com.dev777popov.gifapp.api

import android.util.Log
import com.dev777popov.gifapp.const.Const.API_KEY
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.net.UnknownHostException

class ConnectivityInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        return try {
            val requestBuilder = chain.request()
                .newBuilder()
                .addHeader("api_key", API_KEY)

            chain.proceed(
                requestBuilder.build()
            )

        } catch (e: UnknownHostException) {
            Log.e("TAG", "error ConnectivityInterceptor()")
            throw NoConnectivityException()
        }
    }
}