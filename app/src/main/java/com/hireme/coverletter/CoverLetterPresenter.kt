package com.hireme.coverletter

import com.hireme.util.EmailManager


/**
 * An extremely simple presenter that fetches data from a repository and passes it along to the view.
 */
class CoverLetterPresenter(
    private val view: CoverLetter.View,
    private val repository: CoverLetterRepository,
    private val emailManager: EmailManager
) : CoverLetter.Presenter {

    override fun loadCoverLetter() {
        val coverLetterContent = repository.fetchCoverLetterContent()
        view.showCoverLetter(coverLetterContent)
    }

    override fun startYouAreHiredEmail() = emailManager.startYouAreHiredEmail()
}
