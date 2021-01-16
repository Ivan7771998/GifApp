package com.dev777popov.gifapp

import android.app.Application
import com.dev777popov.gifapp.api.Repository
import com.dev777popov.gifapp.api.ServiceRetrofit
import com.dev777popov.gifapp.const.Const.BASE_URL


class App : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    fun getRepo(): Repository? {
        return repo
    }

    companion object {
        private val retrofitService = ServiceRetrofit.create(BASE_URL)
        val repo = retrofitService?.let { Repository(it) }
    }
}