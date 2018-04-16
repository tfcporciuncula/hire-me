package com.hireme.resume

import android.content.Context
import com.hireme.di.ViewModelScope
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

/**
 * No view being attached to the view model here (obviously), but it's still nice to have a subcomponent if what we're
 * injecting isn't meant to be injectable by anyone who shouldn't know this module.
 */

@ViewModelScope
@Subcomponent(modules = [ResumeModule::class])
interface ResumeComponent {
    fun inject(resumeViewModel: ResumeViewModel)
}

@Module
class ResumeModule {

    @Provides
    @ViewModelScope
    fun provideResumeRepository(context: Context): ResumeRepository {
        return ResumeRepository(context)
    }
}
