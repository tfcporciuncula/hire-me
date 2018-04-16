package com.hireme.di

import android.content.Context
import com.hireme.HireMeApplication
import com.hireme.EmailManager
import com.hireme.coverletter.CoverLetterComponent
import com.hireme.coverletter.CoverLetterModule
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Anything Dagger related that applies to the whole application would go here.
 */

@Module
class ApplicationModule(private val application: HireMeApplication) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideEmailManager(context: Context) = EmailManager(context)
}

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun plus(module: CoverLetterModule): CoverLetterComponent
}
