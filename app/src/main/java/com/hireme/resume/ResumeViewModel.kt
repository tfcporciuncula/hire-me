package com.hireme.resume

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.hireme.EmailManager
import com.hireme.HireMeApplication
import javax.inject.Inject

/**
 * View model + live data!
 */
class ResumeViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var repository: ResumeRepository

    @Inject
    lateinit var emailManager: EmailManager

    val resumeItems = MutableLiveData<List<ResumeItem>>()

    init {
        HireMeApplication
            .getComponent(application.applicationContext)
            .plus(ResumeModule())
            .inject(this)
    }

    fun loadResumeItems(): LiveData<List<ResumeItem>> {
        resumeItems.value = repository.fetchResumeItems()
        return resumeItems
    }

    fun startYouAreHiredEmail() = emailManager.startYouAreHiredEmail()
}
