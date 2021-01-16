package com.dev777popov.gifapp.api

import com.dev777popov.gifapp.model.Data
import com.dev777popov.gifapp.model.MainObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApi {

    @GET("/v1/gifs/search?")
    fun getListGif(@Query("q") search: String, @Query("api_key") api_key: String): Call<MainObject>

}