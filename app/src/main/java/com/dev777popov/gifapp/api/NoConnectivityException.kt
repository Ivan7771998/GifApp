package com.dev777popov.gifapp.api

import java.io.IOException

class NoConnectivityException : IOException() {

    override val message: String?
        get() =  "No connectivity exception"
}