package com.hireme

import android.app.Application
import android.content.Context
import com.hireme.di.ApplicationComponent
import com.hireme.di.ApplicationModule
import com.hireme.di.DaggerApplicationComponent
import timber.log.Timber

/**
 * The application class! Used for now just to initialize Timber and provide the Dagger component.
 */
class HireMeApplication : Application() {

    companion object {
        fun getComponent(context: Context): ApplicationComponent {
            return DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(context.applicationContext as HireMeApplication))
                .build()
        }
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}
