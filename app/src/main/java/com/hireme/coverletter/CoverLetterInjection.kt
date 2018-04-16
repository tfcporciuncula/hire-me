package com.hireme.coverletter

import android.content.Context
import com.hireme.di.FragmentScope
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

/**
 * Yes, Dagger is definitely overkill here. I just wanted to illustrate how it looks interesting when you use a
 * subcomponent to inject a presenter (and its dependencies).
 */

@FragmentScope
@Subcomponent(modules = [CoverLetterModule::class])
interface CoverLetterComponent {
    fun inject(coverLetterFragment: CoverLetterFragment)
}

@Module
class CoverLetterModule(private val view: CoverLetter.View) {

    @Provides
    @FragmentScope
    fun provideCoverLetterPresenter(repository: CoverLetter.Repository): CoverLetter.Presenter {
        return CoverLetterPresenter(view, repository)
    }

    @Provides
    @FragmentScope
    fun provideCoverLetterRepository(context: Context): CoverLetter.Repository {
        return CoverLetterRepository(context)
    }
}