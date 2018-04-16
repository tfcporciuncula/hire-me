package com.hireme.di

import android.content.Context
import com.hireme.util.EmailManager
import com.hireme.util.ExternalUrlManager
import com.hireme.HireMeApplication
import com.hireme.coverletter.CoverLetterComponent
import com.hireme.coverletter.CoverLetterModule
import com.hireme.resume.ResumeComponent
import com.hireme.resume.ResumeModule
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Anything Dagger related that applies to the whole application goes here.
 */

@Module
class ApplicationModule(private val application: HireMeApplication) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideEmailManager(context: Context) = EmailManager(context)

    @Provides
    @Singleton
    fun provideExternalUrlManager(context: Context) = ExternalUrlManager(context)
}

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun plus(module: CoverLetterModule): CoverLetterComponent
    fun plus(module: ResumeModule): ResumeComponent
}
