package com.hireme

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

/**
 * Just a class responsible to start an email intent.
 */
class EmailManager(private val context: Context) {

    fun startYouAreHiredEmail() {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, arrayOf("tfcporciuncula@gmail.com"))
            putExtra(Intent.EXTRA_SUBJECT, "You're hired!")
        }

        intent.resolveActivity(context.packageManager)?.let {
            context.startActivity(intent)
        } ?: Toast.makeText(context, "It seems you have no email clients installed :(", Toast.LENGTH_SHORT).show()
    }
}
