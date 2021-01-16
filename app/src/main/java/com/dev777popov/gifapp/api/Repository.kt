package com.dev777popov.gifapp.api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dev777popov.gifapp.const.Const.API_KEY
import com.dev777popov.gifapp.model.Data
import com.dev777popov.gifapp.model.MainObject
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException

class Repository(private var api: RetrofitApi) {

    fun getListGif(search: String): LiveData<MainObject> {
        val listGif = MutableLiveData<MainObject>()

        GlobalScope.launch {
            try {
                val response  = api.getListGif(search, API_KEY).execute()
                val code = response.code()
                if (code == 200) {
                    listGif.postValue(response.body())
                } else {
                    Log.e("REP", response.errorBody().toString())
                }
            } catch (e: IOException) {
                Log.e("REP", e.printStackTrace().toString())
            }
        }
        return listGif
    }
}