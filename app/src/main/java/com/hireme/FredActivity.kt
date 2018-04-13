package com.hireme

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

/**
 * My second name is Frederico, so people actually call me Fred. And I like these kinds of comments on top of classes.
 * Not really a fan of comments in the middle of the code, though, I'm with Uncle Bob on that one.
 */
class FredActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
