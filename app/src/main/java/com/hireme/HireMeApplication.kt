package com.hireme

import android.app.Application
import timber.log.Timber

class HireMeApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}
