package com.hireme.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.hireme.R

/**
 * Just a class responsible to start an email intent.
 */
class EmailManager(private val context: Context) {

    fun startYouAreHiredEmail() {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, arrayOf(context.getString(R.string.you_are_hired_email)))
            putExtra(Intent.EXTRA_SUBJECT, context.getString(R.string.you_are_hired_subject))
        }

        intent.resolveActivity(context.packageManager)?.let {
            context.startActivity(intent)
        } ?: showErrorMessage()
    }

    private fun showErrorMessage() {
        Toast.makeText(
            context,
            context.getString(R.string.you_are_hired_email_error_message),
            Toast.LENGTH_SHORT
        ).show()
    }
}
