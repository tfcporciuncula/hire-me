package com.hireme.coverletter

/**
 * An extremely simple presenter that fetches data from a repository and passes it along to the view.
 */
class CoverLetterPresenter(
    private val view: CoverLetter.View,
    private val repository: CoverLetter.Repository
) : CoverLetter.Presenter {

    override fun loadCoverLetter() {
        val coverLetterContent = repository.fetchCoverLetterContent()
        view.showCoverLetter(coverLetterContent)
    }
}
