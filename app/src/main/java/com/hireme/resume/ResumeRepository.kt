package com.hireme.resume

import android.content.Context
import com.hireme.R

/**
 * A simple repository that provides the resume items.
 */
class ResumeRepository(private val context: Context) {

    fun fetchResumeItems(): List<ResumeItem> {
        return listOf(
            ResumeItem(
                title = context.getString(R.string.quizlet_title),
                description = context.getString(R.string.quizlet_description),
                imageResId = R.drawable.quizlet,
                dates = context.getString(R.string.quizlet_dates),
                url = context.getString(R.string.quizlet_url)
            ),
            ResumeItem(
                title = context.getString(R.string.abc_title),
                description = context.getString(R.string.abc_description),
                imageResId = R.drawable.abc,
                dates = context.getString(R.string.abc_dates),
                url = context.getString(R.string.abc_url)
            ),
            ResumeItem(
                title = context.getString(R.string.arctouch_title),
                description = context.getString(R.string.arctouch_description),
                imageResId = R.drawable.arctouch,
                dates = context.getString(R.string.arctouch_dates),
                url = context.getString(R.string.arctouch_url)
            ),
            ResumeItem(
                title = context.getString(R.string.softplan_title),
                description = context.getString(R.string.softplan_description),
                imageResId = R.drawable.softplan,
                dates = context.getString(R.string.softplan_dates),
                url = context.getString(R.string.softplan_url)
            ),
            ResumeItem(
                title = context.getString(R.string.sig_title),
                description = context.getString(R.string.sig_description),
                imageResId = R.drawable.esig,
                dates = context.getString(R.string.sig_dates),
                url = context.getString(R.string.sig_url)
            ),
            ResumeItem(
                title = context.getString(R.string.manolos_title),
                description = context.getString(R.string.manolos_description),
                imageResId = R.drawable.manolos,
                dates = context.getString(R.string.manolos_dates),
                url = context.getString(R.string.manolos_url)
            ),
            ResumeItem(
                title = context.getString(R.string.ufrn_title),
                description = context.getString(R.string.ufrn_description),
                imageResId = R.drawable.lii,
                dates = context.getString(R.string.ufrn_dates),
                url = context.getString(R.string.ufrn_url)
            ),
            ResumeItem(
                title = context.getString(R.string.delaware_title),
                description = context.getString(R.string.delaware_description),
                imageResId = R.drawable.delaware,
                dates = context.getString(R.string.delaware_dates),
                url = context.getString(R.string.delaware_url)
            )
        )
    }
}
