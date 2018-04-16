package com.hireme.resume

import android.support.annotation.DrawableRes

/**
 * The model that represents a resume item.
 */
data class ResumeItem(
    val title: String,
    val description: String,
    @DrawableRes val imageResId: Int,
    val url: String
)
