package com.hireme.resume

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.hireme.EmailManager
import com.hireme.HireMeApplication
import javax.inject.Inject

class ResumeViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var emailManager: EmailManager

    init {
        HireMeApplication.getComponent(application.applicationContext).inject(this)
    }

    fun startYouAreHiredEmail() = emailManager.startYouAreHiredEmail()
}
