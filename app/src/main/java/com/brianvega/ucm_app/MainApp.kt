package com.brianvega.ucm_app

import android.app.Application

class MainApp: Application() {

    companion object {
        lateinit var instance: MainApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}