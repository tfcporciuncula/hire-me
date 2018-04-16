package com.hireme.resume

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.hireme.util.EmailManager
import com.hireme.util.ExternalUrlManager
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

    @Inject
    lateinit var externalUrlManager: ExternalUrlManager

    private val resumeItems = MutableLiveData<List<ResumeItem>>()

    fun init() {
        HireMeApplication
            .getComponent(getApplication())
            .plus(ResumeModule())
            .inject(this)
    }

    fun loadResumeItems(): LiveData<List<ResumeItem>> {
        resumeItems.value = repository.fetchResumeItems()
        return resumeItems
    }

    fun startYouAreHiredEmail() = emailManager.startYouAreHiredEmail()

    fun openLinkedin() = externalUrlManager.openLinkedin()

    fun openStackoverflow() = externalUrlManager.openStackoverflow()

    fun openGithub() = externalUrlManager.openGithub()

    fun openUrl(url: String) = externalUrlManager.openUrl(url)
}
