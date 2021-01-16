package com.dev777popov.gifapp.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dev777popov.gifapp.App
import com.dev777popov.gifapp.model.MainObject

class VmGifFragment : ViewModel() {

    fun getListData(search: String): LiveData<MainObject>? {
        return App.repo?.getListGif(search = search)
    }
}