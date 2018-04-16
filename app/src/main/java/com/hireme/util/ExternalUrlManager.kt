package com.hireme.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.hireme.R

/**
 * Class responsible to start the browser to handle external URLs.
 */
class ExternalUrlManager(private val context: Context) {

    fun openLinkedin() = openBrowserFor(context.getString(R.string.linkedin_url))

    fun openStackoverflow() = openBrowserFor(context.getString(R.string.stackoverflow_url))

    fun openGithub() = openBrowserFor(context.getString(R.string.github_url))

    private fun openBrowserFor(url: String) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(url)
        }
        context.startActivity(intent)
    }
}
