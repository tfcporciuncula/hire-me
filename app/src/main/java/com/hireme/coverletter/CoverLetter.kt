package com.hireme.coverletter

/**
 * I'm most experienced with MVP, but I'm also fond of MVVM.
 */
interface CoverLetter {

    interface View {
        fun showCoverLetter(coverLetterContent: String)
    }

    interface Presenter {
        fun loadCoverLetter()
        fun startYouAreHiredEmail()
    }
}
