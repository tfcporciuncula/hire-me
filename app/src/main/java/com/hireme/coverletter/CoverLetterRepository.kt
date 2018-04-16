package com.hireme.coverletter

import android.content.Context
import com.hireme.R

/**
 * Repository to fetch the cover letter content. Super unnecessary since we're currently getting the content from the
 * resources, this is here merely to force the existence of this repository layer.
 */
class CoverLetterRepository(private val context: Context) : CoverLetter.Repository {

    override fun fetchCoverLetterContent(): String = context.getString(R.string.cover_letter)
}
