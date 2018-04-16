package com.hireme.resume

import android.content.Context
import com.hireme.R

/**
 * A simple repository that provides the resume items.
 */
class ResumeRepository(context: Context) {

    fun fetchResumeItems(): List<ResumeItem> {
        return listOf(ResumeItem("title", "description", R.drawable.ic_resume, "http://www.google.com"))
    }
}
