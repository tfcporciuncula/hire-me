package com.hireme.resume

import android.content.Context

/**
 * A simple repository that provides the resume items.
 */
class ResumeRepository(context: Context) {

    fun fetchResumeItems(): List<ResumeItem> {
        return listOf(ResumeItem("test"))
    }
}
